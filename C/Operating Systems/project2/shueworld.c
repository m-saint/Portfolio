#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

int stage[5]; // represents stage with 5 shoeboxes
int typeOnStage;
int rQ;
int dQ; // queues for each type, how many are waiting
int cQ;
int rStreak;
int dStreak; // how many shoes of the same type in a row have entered the stage
int cStreak;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER; // stage mutex 
pthread_cond_t running = PTHREAD_COND_INITIALIZER;
pthread_cond_t dress = PTHREAD_COND_INITIALIZER; // and cv to signal each type
pthread_cond_t crossover = PTHREAD_COND_INITIALIZER;


// separate but pretty much identical function for each type, they have a rock paper scissors kinda relationship

void* sim_r(void* num){

    int shoeNum = *((int*)num);

    while(1){ 

        int waitTime = rand() % 3 + 1;
        int sleepTime;
        printf("[running shoe #%d]: pre-queue waiting for %d seconds\n\n", shoeNum, waitTime);
        sleep(waitTime);
        pthread_mutex_lock(&mutex);
        while(typeOnStage != 1){ // check if shoe is allowed on stage, if not then wait for its type's turn
            rQ++; // one more currently waiting
            printf("[running shoe #%d]: cannot enter\n\n", shoeNum);
            pthread_cond_wait(&running, &mutex);
            rQ--; // been signaled, no longer waiting
        }

        for (int i = 0; i < 5; i++){ // find an unoccupied box
            if (stage[i] == 0){
                stage[i] = 1; // occupied spot
                printf("[running shoe #%d]: taking shoebox %d\n", shoeNum, i);
                rStreak++;
                printf("[running shoe #%d]: current streak is %d\n", shoeNum, rStreak);
                pthread_mutex_unlock(&mutex); // while giving speech, give another shoe a chance to get on stage
                int stageTime = rand() % 3 + 1;
                printf("[running shoe #%d]: on-stage talking for %d seconds\n\n", shoeNum, stageTime);
                sleep(stageTime);
                pthread_mutex_lock(&mutex);
                stage[i] = 0; // empty spot
                printf("[running shoe #%d]: leaving shoebox %d\n", shoeNum, i);
                if (stage[0] + stage[1] + stage[2] + stage[3] + stage[4] == 0){ // if shoe is the last to leave the stage, signal to another type
                    printf("[running shoe #%d]:there are %d dress shoes waiting\n", shoeNum, dQ);
                    printf("[running shoe #%d]:there are %d crossover shoes waiting\n", shoeNum, cQ);
                    if (dQ > 1){ // if there's enough of this type waiting, try them,
                        typeOnStage = 2;
                        rStreak = 0;
                        printf("[running shoe #%d]: UPDATED STAGE TYPE, SIGNALING WAITING DRESS SHOES\n\n", shoeNum);
                        pthread_cond_broadcast(&dress);
                    }
                    else if (cQ > 1){ // if not then try the other
                        typeOnStage = 3;
                        rStreak = 0;
                        printf("[running shoe #%d]: UPDATED STAGE TYPE, SIGNALING WAITING CROSSOVER SHOES\n", shoeNum);
                        pthread_cond_broadcast(&crossover);
                    }
                }
                if (rStreak > 8){ // if this type has been going a bit long,
                    sleepTime = rand() % 7 + 17; //  sleep longer after exiting to slow the flow of shoes onto the stage
                }
                else {
                    sleepTime = rand() % 5 + 8;
                }

                printf("[running shoe #%d]: post-stage resting for %d seconds\n\n", shoeNum, sleepTime);
                break;
            }
        }
        pthread_mutex_unlock(&mutex); // no longer have control of the stage
        sleep(sleepTime);
    }
}

void* sim_d(void* num){

    int shoeNum = *((int*)num);

    while(1){
    
        int waitTime = rand() % 3 + 1;
        int sleepTime;
        printf("[dress shoe #%d]: pre-queue waiting for %d seconds\n\n", shoeNum, waitTime);
        sleep(waitTime);
        pthread_mutex_lock(&mutex);
        while(typeOnStage != 2){
            dQ++;
            printf("[dress shoe #%d]: cannot enter\n\n", shoeNum);
            pthread_cond_wait(&dress, &mutex);
            dQ--;
        }

        for (int i = 0; i < 5; i++){
            if (stage[i] == 0){
                stage[i] = 1;
                printf("[dress shoe #%d]: taking shoebox %d\n", shoeNum, i);
                dStreak++;
                printf("[dress shoe #%d]: current streak is %d\n", shoeNum, dStreak);
                pthread_mutex_unlock(&mutex);
                int stageTime = rand() % 3 + 1;
                printf("[dress shoe #%d]: on-stage talking for %d seconds\n\n", shoeNum, stageTime);
                sleep(stageTime);
                pthread_mutex_lock(&mutex);
                stage[i] = 0;
                printf("[dress shoe #%d]: leaving shoebox %d\n", shoeNum, i);
                if (stage[0] + stage[1] + stage[2] + stage[3] + stage[4] == 0){
                    printf("[dress shoe #%d]: there are %d crossover shoes waiting\n", shoeNum, cQ);
                    printf("[dress shoe #%d]: there are %d running shoes waiting\n", shoeNum, rQ);
                    if (cQ > 1){
                        typeOnStage = 3;
                        dStreak = 0;
                        printf("[dress shoe #%d]: UPDATED STAGE TYPE, SIGNALING WAITING CROSSOVER SHOES\n", shoeNum);
                        pthread_cond_broadcast(&crossover);
                    }
                    else if (rQ > 1){
                        typeOnStage = 1;
                        dStreak = 0;
                        printf("[dress shoe #%d]: UPDATED STAGE TYPE, SIGNALING WAITING RUNNING SHOES\n", shoeNum);
                        pthread_cond_broadcast(&running);
                    }
                }
                if (dStreak > 8){
                    sleepTime = rand() % 7 + 17;
                }
                else {
                    sleepTime = rand() % 5 + 8;
                }

                printf("[dress shoe #%d]: post-stage resting for %d seconds\n\n", shoeNum, sleepTime);
                break;
            }
        }
        pthread_mutex_unlock(&mutex);
        sleep(sleepTime);
    }
}

void* sim_c(void* num){

    int shoeNum = *((int*)num);

    while(1){
    
        int waitTime = rand() % 3 + 1;
        int sleepTime;
        printf("[crossover shoe #%d]: pre-queue waiting for %d seconds\n\n", shoeNum, waitTime);
        sleep(waitTime);
        pthread_mutex_lock(&mutex);
        while(typeOnStage != 3){
            cQ++;
            printf("[crossover shoe #%d]: cannot enter\n\n", shoeNum);
            pthread_cond_wait(&crossover, &mutex);
            cQ--;
        }

        for (int i = 0; i < 5; i++){
            if (stage[i] == 0){
                stage[i] = 1;
                printf("[crossover shoe #%d]: taking shoebox %d\n", shoeNum, i);
                cStreak++;
                printf("[crossover shoe #%d]: current streak is %d\n", shoeNum, cStreak);
                pthread_mutex_unlock(&mutex);
                int stageTime = rand() % 3 + 1;
                printf("[crossover shoe #%d]: on-stage talking for %d seconds\n\n", shoeNum, stageTime);
                sleep(stageTime);
                pthread_mutex_lock(&mutex);
                stage[i] = 0;
                printf("[crossover shoe #%d]: leaving shoebox %d\n", shoeNum, i);
                if (stage[0] + stage[1] + stage[2] + stage[3] + stage[4] == 0){
                    printf("[crossover shoe #%d]: there are %d running shoes waiting\n", shoeNum, rQ);
                    printf("[crossover shoe #%d]: there are %d dress shoes waiting\n", shoeNum, dQ);
                    if (rQ > 1){
                        typeOnStage = 1;
                        cStreak = 0;
                        printf("[crossover shoe #%d]: UPDATED STAGE TYPE, SIGNALING WAITING RUNNING SHOES\n", shoeNum);
                        pthread_cond_broadcast(&running);
                    }
                    else if (dQ > 1){
                        typeOnStage = 2;
                        cStreak = 0;
                        printf("[crossover shoe #%d]: UPDATED STAGE TYPE, SIGNALING WAITING DRESS SHOES\n", shoeNum);
                        pthread_cond_broadcast(&dress);
                    }
                }

                if (cStreak > 8){
                    sleepTime = rand() % 7 + 17;
                }
                else {
                    sleepTime = rand() % 5 + 8;
                }

                printf("[crossover shoe #%d]: post-stage resting for %d seconds\n\n", shoeNum, sleepTime);
                break;
            }
        }
        pthread_mutex_unlock(&mutex);
        sleep(sleepTime);
    }
}


int main(){

	FILE* seedFile = fopen("seed.txt","r"); // opening file with seed

	char seedStr[100]; //will store seed in str form

	fscanf(seedFile, "%s", seedStr); // reads seed  from file

	int seedInt = atoi(seedStr); // convert to int

	srand(seedInt); // seeds random number generation

    // initialize global variables

    for (int i = 0; i < 5; i++){
        stage[i] = 0;
    }
    typeOnStage = rand() % 3 + 1; // who gets to go on first
    rQ, dQ, cQ, rStreak, dStreak, cStreak = 0;

    // create threads, send them off with their number

    pthread_t running[19];
    pthread_t dress[17];
    pthread_t crossover[14];

    for (int i = 0; i < 19; i ++){
        int* shoeNum = malloc(sizeof(*shoeNum));
        *shoeNum = i;
        pthread_create(&running[i], NULL, sim_r, shoeNum);
    }

    for (int i = 0; i < 17; i ++){
        int* shoeNum = malloc(sizeof(*shoeNum));
        *shoeNum = i;
        pthread_create(&dress[i], NULL, sim_d, shoeNum);
    }

    for (int i = 0; i < 14; i ++){
        int* shoeNum = malloc(sizeof(*shoeNum));
        *shoeNum = i;
        pthread_create(&crossover[i], NULL, sim_c, shoeNum);
    }

    for (int i = 0; i < 19; i ++){
        pthread_join(running[i], NULL);
    }

    for (int i = 0; i < 17; i ++){
        pthread_join(dress[i], NULL);
    }

    for (int i = 0; i < 14; i ++){
        pthread_join(crossover[i], NULL);
    }

    return 0;

}