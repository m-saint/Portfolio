#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>
#include <time.h>

int main() {

	time_t start = time(0); // gets start time for later comparison

	int w[4]; // will hold child exit info
	for (int a = 0; a < 4; a++){
		w[a] = 69; // initialize the entire array to something other than zero, because we need to differentiate between default value and child exit value
	}

	for (int i = 0; i < 4; i++){ // repeat for each child we will have
		printf("i created child %d\n", getpid()+i+1);
		int f = fork(); // creates child process
		if (f == 0){ // if process is child, ...
			char* args[3];
			args[0] = "./waiter";
			char arg[2];
			sprintf(arg, "%d", i+1); // allows us to pass the desired int as an argument to execvp
			args[1] = arg;
			args[2] = NULL;
			printf("%d is executing ./waiter %s\n",getpid(),arg);
			execvp("./waiter", args); // executes command with specified argument
		}

	}

	int done[4]; // will store whether or not each child has been recorded finishing the race (0 or 1)

	while(w[0]+w[1]+w[2]+w[3] != 0){ // while there are still children running
		for (int j = 0; j < 4; j++){ // for each child
			waitpid(getpid()+j+1, &w[j], WNOHANG); // waits for child but will not block, we have other things to do
			if (done[j] == 0){ // if we haven't recorded this finished child yet
				if (w[j] != 69){ // if this child has returned and hasn't already been recorded
					time_t end = time(0); // time when the child finishes, used in below calculation
					printf("child %d finished after %f seconds\n", getpid()+j+1, difftime(end,start)); // how long child took to finish
					done[j] = 1; // no repeats
				}

				else {
					usleep(200000); // .2 seconds
					printf("%d is still running\n", getpid()+j+1); // print currently racing waiters
				}
			}
		}
	}
	time_t end = time(0); // final time
	printf("everybody is done, it took %f seconds\n", difftime(end,start)); // how long the race lasted
}
