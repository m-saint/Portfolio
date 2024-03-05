
#include "Cat.h"

/*******************************************************************************
* Cat::Cat(string tp, string c):Animal(c)
* // constructs a Cat object of type tp and color c, inherits Animal

    string tp: the type of the cat/animal
    string c: the color of the cat/animal
********************************************************************************/
Cat::Cat(string tp, string c):Animal(c){

    type = tp;
}

/*******************************************************************************
* Cat::Cat():Animal("black")
* // constructs a Cat object of default type "unk" and
* // color black when neither field is specified, inherits Animal
********************************************************************************/
Cat::Cat():Animal("black"){ // default color is black
    type = "unk"; // default type is unk
}

/*******************************************************************************
* void Cat::setType(string tp)
* // sets the type of the cat object to tp
* // string tp: the type
********************************************************************************/
void Cat::setType(string tp) {
    type = tp;
}

/*******************************************************************************
* void Cat::displayInfo(string c)
* // prints the type and color of the cat
* // string c: the color
********************************************************************************/
void Cat::displayInfo(string c) {
    cout << "I am a " << type << endl; //prints type of calling cat object
    cout << "My color is " << c << endl;
}

/*******************************************************************************
* void Cat::meow()
* // prints a silly lil message -> "I can speak! Meow meow!!" 
********************************************************************************/
void Cat::meow() {
    cout << "I can speak! Meow meow!!" << endl;
}
