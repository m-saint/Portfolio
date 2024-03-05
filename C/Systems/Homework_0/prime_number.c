#include <stdio.h>

int main(void){
    //Initialize variable
    int num;

    //Prompt user for value
    //Get value from terminal and store in variable
    printf("Please enter a value:\n");
    scanf("%d", &num);

    // we don't bother with any input less than 2
    if (num < 2){
        printf("This value is not a prime number");
    }

    else {
        //Initialize variable
        int prime = 1;
    
         //Loop over all numbers  (x) less than the specified value (v)
        //if the v/x is a whole number (hint, use the % operator which returns 
        //the remainder of a/b)
        //then the value is not prime
        //print "This value is not a prime number" to the terminal
        for (int i = 2; i < num; i++){
            int rem = num%i;
            if (rem == 0){
                printf("This value is not a prime number.");
                prime = 0;
                break;
            }
        }

        //Exit the loop
        //If v/x was never a whole number
        //print "This value is a prime number" to the terminal
        if (prime == 1){
            printf("This value is a prime number");
        }
    }
}