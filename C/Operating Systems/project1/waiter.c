#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char* argv[]){

	FILE* seedFile;

	int fileNum = atoi(argv[1]);

	switch(fileNum){ // opens correct file

	case 1:
		seedFile  = fopen("seed_waiter_1.txt", "r");
		break;
	case 2:
		seedFile  = fopen("seed_waiter_2.txt", "r");
		break;
	case 3:
		seedFile  = fopen("seed_waiter_3.txt", "r");
		break;
	case 4:
		seedFile  = fopen("seed_waiter_4.txt", "r");
		break;
	}

	// gets seed from file, converts to int, then seeds random number generation
	char seedStr[100];
	fscanf(seedFile, "%s", seedStr);
	int seedInt = atoi(seedStr);
	srand(seedInt);

	printf("seed is %d\n", seedInt);

	// generates random numbers for delay and coinflip
	int delay =(rand() % 6) + 4;
	int flip = rand() % 2;

	printf("delay %d seconds, flip result %d\n", delay, flip);
	sleep(delay); // wait appropriate length of time
	if (flip == 0){
		printf("running last -i -x\n");
		char* args[4];
                args[0] = "last";
                args[1] = "-i";
		args[2] = "-x";
                args[3] = NULL;
                execvp("last", args); // executes the command determined by coinflip
	}

	else {
		printf("running id --group\n");
		char* args[3];
                args[0] = "id";
                args[1] = "--group";
                args[2] = NULL;
                execvp("id", args);

	}

}
