matrix_calc.c and matrix_math.c and matrix_math.h and makefile
Myles St. Jean
2/21/23

- reads two 1xN matrices from files and perform addition or subtraction
- Stores data in structs to represent matrices
- prints result to terminal

details: 
- only runs for matrices of compatible size, as normal
- size and data are stored in and accessed from created matrix structs
- uses 'a' as a command argument for addition, and s for subtraction, and n for average if you're feelin wild
- deletes structs when finished

To compile:
gcc -o matrixCalc.exe matrix_calc.c matrix_math.c
or
make matrixCalc

To run:
./matrixCalc.exe file1 file2 type

sources: just me
