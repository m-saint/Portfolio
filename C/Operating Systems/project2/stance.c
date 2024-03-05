#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

int mat[4]; // mat representation with 4 stance spaces
char* stanceList[5]; // holds the actual names of the stances for printing
int cardCounter; // how many cards have been drawn
sem_t teams[4]; // make sure only one person per team is active
sem_t stances[4]; // make sure only one player is on a stance at a time
sem_t reserving; // only one player may be reserving spots at a time

void* justStance(void* num){

    int playerNum = *((int*)num);

    int team = rand() % 4; // each player randomly selects which team they will be on

    while(1){

        sem_wait(&teams[team]); // one per team in this section

        // making a stanceCard

        int stanceCard[4];

        int cardLength = rand() % 4 + 1;

        for (int i = 0; i < cardLength; i++) {
            stanceCard[i] = rand() % 4;
            int j = 0;
            while (j < i){ // no repeats allowed
                if (stanceCard[j] == stanceCard[i]){
                    stanceCard[i] = rand() % 4;
                    j=-1;
                }
                j++;
            }
        }

        printf("[player #%d, team %d]:  card # %d is ", playerNum, team, cardCounter);
        for (int k = 0; k < cardLength; k++){
            printf("%s", stanceList[stanceCard[k]]);
        }
        printf("\n\n");
        cardCounter++;

        sem_wait(&reserving); // one player at a time in this section

        int success = 0;
        int fails = 0;
        while (success == 0){

            if (fails < 3){ // if a player is starving it gets to skip this obstacle
                fails++;
                sem_post(&reserving);
                sleep(1);
                sem_wait(&reserving);
            }

            int path = 0;
            for (int i = 0; i < cardLength; i++){
                path += mat[stanceCard[i]];
            }

            if (path == 0){ // if nobody was in your way, reserve all stances
                for (int j = 0; j < cardLength; j++){
                    sem_wait(&stances[stanceCard[j]]);
                    printf("[player #%d, team %d]:  reserved %s\n", playerNum, team, stanceList[stanceCard[j]]);
                }
                success = 1;
                fails = 0;
                sem_post(&reserving);
            }
            else { // if you can't reserve all your stances, you reserve none and must try again later
                fails++;
                sem_post(&reserving);
                sem_wait(&reserving);
            }
        }

        // player(s) on the mat, do each stance and unclaim it when done

        for (int stanceNum = 0; stanceNum < cardLength; stanceNum++){

            mat[stanceCard[stanceNum]] = 1;
            printf("[player #%d, team %d]:  hopping to %s\n", playerNum, team, stanceList[stanceCard[stanceNum]]);
            sleep(rand() % 3 + 1);
            printf("[player #%d, team %d]:  hopping off %s\n", playerNum, team, stanceList[stanceCard[stanceNum]]);
            mat[stanceCard[stanceNum]] = 0;
            sem_post(&stances[stanceCard[stanceNum]]);
        }

        printf("[player #%d, team %d]:  off the mat, tagging in teammate\n\n", playerNum, team); // finished with stance card, go to back of line
        sem_post(&teams[team]);
        sleep(rand() % 3 + 1);
    }
}


int main(){

	FILE* seedFile = fopen("seed.txt","r"); // opening file with seed

	char seedStr[100]; //will store seed in str form

	fscanf(seedFile, "%s", seedStr); // reads seed  from file

	int seedInt = atoi(seedStr); // convert to int

	srand(seedInt); // seeds random number generation

    // initialize global variables

    for (int i = 0; i < 4; i++){
        mat[i] = 0;
        sem_init(&stances[i], 0, 1);
        sem_init(&teams[i], 0, 1);
    }

    sem_init(&reserving, 0, 1);

    stanceList[0] = "(Warrior Stance) ";
    stanceList[1] = "(Tree Pose) ";
    stanceList[2] = "(Wheel Pose) ";
    stanceList[3] = "(Plank Pose) ";

    cardCounter = 0;

    // create threads

    pthread_t players[68];

    for (int j = 0; j < 68; j ++){ // make players, send them off with their number attached
        int* playerNum = malloc(sizeof(*playerNum));
        *playerNum = j;
        pthread_create(&players[j], NULL, justStance, playerNum);
    }

    for (int k = 0; k < 68; k++){
        pthread_join(players[k], NULL);
    }

    return 0;

}