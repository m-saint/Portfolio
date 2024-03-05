#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {

	FILE* seedFile = fopen("seed.txt","r"); // opening file with seed

	char seedStr[100]; //will store seed in str form

	fscanf(seedFile, "%s", seedStr); // reads seed  from file

	int seedInt = atoi(seedStr); // convert to int

	srand(seedInt); // seeds random number generation

	int numKids = (rand() % 7) + 5; // rand % 7 gets us 0 to 6, so adding 5 gets us 5 to 11

	int randomNums[numKids]; // will store each child's random number for it to access later

	printf("seed value is %d\n", seedInt);
	printf("there will be %d children\n", numKids);

	for (int i = 0; i < numKids; i++){ // repeat for each child we will have
		randomNums[i] = rand(); // fills in random number for the coming child to use
		printf("waiting on pid %d\n", getpid()+i+1);
		int f = fork(); // creates child process
		int w; // will store child exit info
		if (f == 0){ // if process is child, ...
			printf("i am child, pid %d, i will wait %d seconds then exit with code %d\n", getpid(), (randomNums[i] % 3) + 1, (randomNums[i] % 50) + 1);
			sleep((randomNums[i] % 3) + 1);
			printf(" exiting\n");
			exit((randomNums[i] % 50) + 1);
		}

		else { // if process is parent
			waitpid((getpid()+1+i), &w, 0); // wait for child to exit first, store exit info in w
			printf("child %d exited with code %d\n",(getpid()+i+1), w/256); // we only want the exit code from w, so div by 256
		}
	}

}
