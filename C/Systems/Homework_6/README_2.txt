Cat.cpp and Animal.cpp and test_cat.cpp
Myles St. Jean
2/27/23

- implements Cat.cpp, as defined in Cat.h, which inherits Animal 
- includes: 
    - a default and a specific constructor
    - a setter for the type field of Cat/Animal
    - display function that prints the type and color
    - a meow function

To compile:
g++ -Wall test_cat.cpp Cat.cpp Animal.cpp -lm -o runCat

To run:
./runCat.exe 

sources: just me n the starter code
