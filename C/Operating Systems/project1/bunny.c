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

	printf("seed value is %d\n", seedInt);

	for (int i = 0; i < 5; i++){ // repeat for each child we will have
		int loc = rand() % 6;
		switch(loc){
			case 0: printf("selected /home\n");
				chdir("/home");
				break;
			case 1: printf("selected /proc\n");
				chdir("/proc");
				break;
			case 2: printf("selected /proc/sys\n");
				chdir("/proc/sys");
				break;
			case 3: printf("selected /usr\n");
				chdir("/usr");
				break;
			case 4: printf("selected /boot\n");
				chdir("/boot");
				break;
			case 5: printf("selected /sbin\n");
				chdir("/sbin");
				break;
		}
		char dir[69];
		getcwd(dir, sizeof(dir));
		printf("%s\n", dir);
		printf("waiting on pid %d\n", getpid()+i+1);
		int f = fork(); // creates child process
		int w; // will store child exit info
		if (f == 0){ // if process is child, ...
			printf("doing ls -tr\n");
			char* args[3];
			args[0] = "ls";
			args[1] = "-tr";
			args[2] = NULL;
			execvp("ls", args); // execute command with specified arguments
			exit(0);
		}

		else { // if process is parent
			waitpid((getpid()+1+i), &w, 0); // wait for child to exit first, store exit info in w
			printf("child %d exited with code %d\n",(getpid()+i+1), w/256); // we only want the exit code from w, so div by 256
		}
	}

}
