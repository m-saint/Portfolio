prime_number.c
Myles St. Jean
1/16/2023

- takes an integer value from the user and determines if the value is prime number
- prints the answer

details:
- checks if the input is less than 2 to see if we even have to do any more work
- if we gotta check further it loops through from 2 up to input-1, checking remainders
- we've got a variable that represents whether or not we're still composite-free after all those iterations
- if at any point we have a zero remainder, we print it's not prime, set our prime checker to 0 (false), and bust out of the loop
- if at the end of the program and our prime checker is still 1, it prints prime and we're done

To compile:
gcc -Wall prime_number.c

To run:
./a.exe

sources: just me

