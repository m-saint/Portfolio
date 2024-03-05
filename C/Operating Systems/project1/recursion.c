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

	int lifespan = (rand() % 7) + 8; // rand % 7 gets us 0 to 6, so adding 8 gets us 8 to 14

	printf("seed value is %d\n", seedInt);
	printf("lifespan count will be %d \n", lifespan);

	int counter = lifespan; // initialize counter to lifespan so we don't have to change lifespan and break things

	for (int i = 0; i < lifespan; i++){ // repeat for each child we will have
		printf("pid %d :  waiting on pid %d\n",getpid(),  getpid()+1);
		int w; // will store child exit info
		int f = fork();
		if (f == 0){ // if process is child, ...
			printf("pid %d :  current descendant count: %d, I will have %d descendants\n",getpid(), counter, counter-1);
			counter -= 1;
		}

		else { // if process is parent
			waitpid((getpid()+1), &w, 0); // wait for child to exit first, store exit info in w
			printf("pid %d : child %d exited with code %d, i will exit now\n",getpid(),(getpid()+1), w/256); // we only want the exit code from w, so div by 256
			exit(w/256 + 1);
		}
	}
}
