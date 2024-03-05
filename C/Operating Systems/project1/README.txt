Myles St. Jean - Project 1

scenario overview:

1. i used a for loop to repeat for each child process to be created, and within that loop i forked off the child, and used an if else statement to differentiate between child and parent. child processes do their things with their assigned random number from an array. the parent process waits for each child to exit before the program proceeds. this approach ensures a consistent output run to run.

2. a similar style to scenario 1. i first initialized a counter variable to match the calculated lifespan. this will help when representing the current descendant count and number of descendants. i used a for loop to repeat for each cycle of the lifespan. inside the loop i forked off the child, and used an if else statement to differentiate between parent and child in each generation. child processes print out their info and then decrement the counter. parent processes wait for their child to exit before the program proceeds, and then uses its child's exit code it got from wait to calculate and exit with its own code. this approach again ensures consistent output, and also exhibits recursive behavior where processes can act both as the child and as the parent until the lifespan is completed.

3. i use a for loop to repeat for each child process to be created. inside the loop i determine the location to be gone to and use a switch case to change directory to the corresponding location. a child is then forked off, and an if else statement is used to differentiate between them so the parent process can wait for each child in turn to finish before proceeding. each child process executes its appropriate command with execvp.

4. i use a switch case to determine which seed file to open based on the given command line input. the programs sleeps for the calculated amount of time, and then executes the command (using execvp) determined by the calculated coin flip value (using an if else statement).

5. i create a time_t variable to keep track of the time the program began. i then manually initialized my array to store child exit values to be a new different number by default, so I'd be able to tell which children had exited with code 0 and which hadn't yet exited. i then used a for loop to repeat for each child process to be created. inside the loop i fork off a child, then use an if else statement to differentiate between parent and child. child processes each execute the waiter program with a command line value correspondent to the loop index variable (each child will execute waiter with a different seed file 1 through 4). after that loop has been completed, i create an array to store which children have finished the race. i then use a while loop which runs as long as there is at least one child who hasn't yet returned (filled their w values as 0 in the array made earlier). inside that loop i use a for loop which runs for each created child. inside that loop is where i put my waitpid, which i give the WNOHANG parameter to prevent blocking. i then use an if else statement to check if the child process currently being looked at (index in the inner for loop) has exited yet. if it has, the time is noted, the child's race time is calculated and displayed, and the child is marked as done with the race in the array i mentioned earlier. if the child was not done, the program sleeps briefly before displaying itself as a currently racing process. at the end of the while loop, the end of the program, the time is noted and the final duration of the race is calculated and displayed. 


other notes:

- also see the comments in the code for each scenario

- i tested each scenario mainly by comparing it with the example outputs, and also by trying a few different seed values to make sure it ran as expected. ive run my solution for each scenario probably a hundred times by now, and expected behavior is observed every time.

- i didnt really use a debugger since most of the issues i ran into werent of the sort that a debugger could identify. for troubleshooting i mainly consulted the man pages and explanations/examples from the textbook if i could find any. lots of trial and error as well as dumb mistakes. 


