coffee_shop.c and pos_programs.c and pos_programs.h and makefile
Myles St. Jean
1/31/23

- asks which task to perform out of the following:
   - Read the file and calculate the overall revenue for the day. 
   - Read the file and calculate the balance in the cash register at the end of the day. 
   - Reads the file and tallies the number of times a particular item was sold aNd tHe tOtaL rEveNue fRoM thAt IteM.  

details: 
- prompts user for which program they wanna run, as well as file info and relevant parameters
- prints to terminal for overall revenue or register balance, prints to a file the item-specific revenue 

To compile:
gcc -o sales coffee_shop.c pos_programs.c
or
make sales

To run:
./sales.exe

sources: just me
