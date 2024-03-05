#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

unsigned char memory[64];
int registers[4]; // addresses of the start of each process' page table
int freeList[4]; // which physical frames are not allocated

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
        if (count == 4){ // not enough frames
            printf("error: cannot satisfy request\n");
            return;
        }
        // store this vpn's pfn and permissions in this process' page table
        memory[registers[pid]+(4*vpn)] = pfn;
        memory[registers[pid]+(4*vpn)+2] = value;
        printf("virtual page %d mapped to physical frame %d\n", vpn, pfn);
    }
    else if (memory[registers[pid]+(4*vpn)+2] != value){
        memory[registers[pid]+(4*vpn)+2] = value;
        printf("updated permissions for virtual page %d\n", vpn);
    }
    else {
        printf("virtual page %d is already mapped\n", vpn);
    }
}

void store(int pid, int va, int value){
    int vpn = va / 16;

    if (memory[registers[pid]+(4*vpn)] != 99){
        if (memory[registers[pid]+(4*vpn)+2] != 0){
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

    // initialize global variables
    for (int i = 0; i < 4; i++){
        registers[i] = -1;
        freeList[i] = 1;
    }

    while(1){

        int pid, va, value = 0;
        char inst[5];
        printf("Instruction? ");
        if (scanf("%d,%[^,],%d,%d", &pid, inst, &va, &value) == 4){

            // check input

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

            if (registers[pid] == -1){
                int count = 0;
                for (int i = 0; i < 4; i++){
                    if (freeList[i] == 1){
                        for (int j = 16*i; j < 16*i + 16; j++){ // allocate physical frame
                            memory[j] = 99;
                        }
                        printf("page table for process %d allocated on physical frame %d\n", pid, i);
                        freeList[i] = 0;
                        registers[pid] = 16*i;
                        break;
                    }
                    count++;
                }
                if (count == 4){ // not enough frames
                    printf("error: cannot satisfy request\n");
                    continue;
                }
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