#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <time.h>

unsigned char memory[64];
unsigned char disk[320];
int registers[4]; // starting addresses each process' page table
int freeList[4]; // which physical frames are not allocated

int evict(int reqPage){ // evict something that is not reqPage

    int evicted = rand() % 4;
    int fail;

    while (evicted == reqPage){ // trying to evict a page we need to keep
        evicted = rand() % 4;
    }

    int i = 0;
    while(1){

        if (registers[i] == -1){ // don't bother with processes that haven't shown up in an instruction yet
            i++;
            continue;
        }

        if (i == 4){ // if we can't successfully evict this page (usually page table on disk), start over and try another page
            fail = evicted;
            evicted = rand() % 4;
            while (evicted == reqPage || evicted == fail){
                evicted = rand() % 4;
            }
            i = 0;
        }

        if (registers[i] == 16*evicted){ // we're evicting a page table

            int presentPageTables = 0;
            for (int i = 0; i < 4; i++){
                if (registers[i] != 16*4){
                    presentPageTables++;
                }
            }

            if (presentPageTables < 2){ // for ease of swapping, we don't want to evict a page table if that would leave only one page table in memory 
                fail = evicted;
                evicted = rand() % 4;
                while (evicted == reqPage || evicted == fail){
                    evicted = rand() % 4;
                }
                i = 0;
                continue; // start over and try a different page
            }

            registers[i] = 16*4; // update register to reflect absence

            for (int j = 0; j < 16; j++){
                disk[i*80 + j] = memory[16*evicted + j]; // copy to disk
                memory[16*evicted + j] = 0;
            }

            printf("wrote page table for process %d (physical frame %d) to disk\n\n", i, evicted);
            return evicted;
        }
        else {
            for (int j = 0; j < 4; j++){
                if (memory[registers[i] + 4*j] == evicted){ // we're evicting an actual page
                    memory[registers[i] + 4*j] = 4;
                    memory[registers[i] + (4*j) + 2] = 0; // update page table to reflect absence

                    for (int k = 0; k < 16; k++){
                        disk[i*80 + 16*(j+1) + k] = memory[16*evicted + k];
                        memory[16*evicted + k] = 0;
                    }

                    printf("wrote pid %d virtual page %d (physical frame %d) to disk\n\n", i, j, evicted);
                    return evicted;
                }
            }
        }
        i++;
    }
}

void map(int pid, int va, int value){

    int vpn = va / 16;
    int pfn;
    int count = 0;

    if (memory[registers[pid]+(4*vpn)] == 99){
        for (int i = 0; i < 4; i++){
            if (freeList[i] == 1){
                pfn = i;
                freeList[i] = 0;
                break;
            }
            count++;
        }
        if (count == 4){ // no free frames
            printf("\n");
            pfn = evict(registers[pid] / 16); // clear a spot
        }

        // store this vp's pfn, permissions, and presence, in this process' page table
        memory[registers[pid]+(4*vpn)] = pfn;
        memory[registers[pid]+(4*vpn)+1] = value;
        memory[registers[pid]+(4*vpn)+2] = 1;
        printf("virtual page %d mapped to physical frame %d\n", vpn, pfn);
    }
    else if (memory[registers[pid]+(4*vpn)+1] != value){
        memory[registers[pid]+(4*vpn)+1] = value;
        printf("updated permissions for virtual page %d\n", vpn);
    }
    else {
        printf("virtual page %d is already mapped\n", vpn);
    }
}

void store(int pid, int va, int value){

    int vpn = va / 16;

    if (memory[registers[pid]+(4*vpn)+2] == 0){ // page on disk

        printf("\n");
        int frame = evict(registers[pid] / 16); // clear a spot

        for (int i = 0; i < 16; i++){
            memory[16*frame + i] = disk[pid*80 + 16*(vpn+1) + i]; // copy from disk
        }

        memory[registers[pid]+(4*vpn)] = frame; // update page table with location
        memory[registers[pid]+(4*vpn)+2] = 1; // and presence
        printf("moved virtual page %d from disk to physical frame %d\n", vpn, frame);
    }

    if (memory[registers[pid]+(4*vpn)] != 99){ // page has been mapped
        if (memory[registers[pid]+(4*vpn)+1] != 0){ // page is writable
            int pa = (memory[registers[pid]+(4*vpn)] * 16) + (va % 16); // pfn*pagesize + offset
            memory[pa] = value;
            printf("stored value %d at physical address %d\n", value, pa);
        }
        else {
            printf("error: virtual page %d is read-only\n", vpn);
        }
    }
    else {
        printf("error: virtual page %d has not been mapped\n", vpn);
    }
}

void load(int pid, int va){ // same as store, but read instead of write

    int vpn = va / 16;

    if (memory[registers[pid]+(4*vpn)+2] == 0){ 

        printf("\n");
        int frame = evict(registers[pid] / 16);

        for (int i = 0; i < 16; i++){
            memory[16*frame + i] = disk[pid*80 + 16*(vpn+1) + i];
        }

        memory[registers[pid]+(4*vpn)] = frame;
        memory[registers[pid]+(4*vpn)+2] = 1;
        printf("moved virtual page %d from disk to physical frame %d\n", vpn, frame);
        
    }

    if (memory[registers[pid]+(4*vpn)] != 99){
        int pa = (memory[registers[pid]+(4*vpn)] * 16) + (va % 16);
        int value = memory[pa];
        printf("value %d is stored at physical address %d\n", value, pa);
    }
    else {
        printf("error: virtual page %d has not been mapped\n", vpn);
    }  
}

int main(int argc, char * argv[]){

    srand(time(NULL));

    // initialize global variables
    for (int i = 0; i < 4; i++){
        registers[i] = -1;
        freeList[i] = 1;
    }

    while(1){ // take instructions

        int pid, va, value = 0;
        char inst[5];
        printf("\nInstruction? ");
        if (scanf("%d,%[^,],%d,%d", &pid, inst, &va, &value) == 4) {

            // check for valid input

            if (pid < 0 || pid > 3){
                printf("invalid pid\n");
                continue;
            }

            if (va < 0 || va > 63){
                printf("invalid address\n");
                continue;
            }

            if (value < 0 || value > 255){
                printf("invalid value\n");
                continue;
            }

            // page table creation

            if (registers[pid] == -1){ // page table doesn't exist

                int count = 0;
                for (int i = 0; i < 4; i++){
                    if (freeList[i] == 1){
                        for (int j = 16*i; j < 16*i + 16; j++){ // allocate physical frame
                            memory[j] = 99;
                        }
                        freeList[i] = 0;
                        registers[pid] = 16*i; // the start of this process' page table
                        printf("page table for process %d allocated on physical frame %d\n", pid, i);
                        break;
                    }
                    count++;
                }
                if (count == 4){ // no free frames

                    printf("\n");
                    int frame = evict(4); // make a spot
                    for (int i = 16*frame; i < 16*frame + 16; i++){ // allocate physical frame
                        memory[i] = 99;
                    }
                    registers[pid] = 16*frame;
                    printf("page table for process %d allocated on physical frame %d\n", pid, frame);
                }
            }
            else if (registers[pid] == 64){ // page table is on disk

                printf("\n");
                int frame = evict(memory[registers[pid]+(4*(va/16))]); // make a spot, don't evict the page needed for the instruction

                for (int i = 0; i < 16; i++){
                    memory[16*frame + i] = disk[pid*80 + i]; 
                }

                registers[pid] = 16*frame;
                printf("moved page table for process %d from disk into physical frame %d\n", pid, frame);
            }


            // do desired instruction

            if (strcmp(inst, "map") == 0){
                map(pid, va, value);
            } else if (strcmp(inst, "store") == 0){
                store(pid, va, value);
            } else if (strcmp(inst, "load") == 0){
                load(pid, va);
            } else {
                printf("invalid instruction\n");
            }

        } else {
            printf("invalid format.\n");
            break;
        }
    }
}