#include <iostream>
#include <string>
#include <iomanip>

#include "Matrix.h"

Matrix::Matrix(int l1){
    length = l1;
    data = new float[length];
    
}


Matrix::Matrix(){
    length = 0;
    data = NULL;
    
}



void Matrix::readMatrix(string fileName) {
    ifstream input;
    input.open(fileName);
    
    for (int i = 0; i < length; i++){
        input >> data[i];
    }
    input.close();
}




/*******************************************************************************
* void print(Matrix& A){
*
* Output:
*   Prints A to the screen
********************************************************************************/

void Matrix::print(){

   // print values to screen
    for (int i = 0; i < length; i++){
       cout << std::setw(8) << data[i];  
    }
    printf("\n");

}

/*******************************************************************************
* Matrix::~Matrix()
*
* Deconstructor for Matrix object
********************************************************************************/
Matrix::~Matrix(){
    delete data;
}


int Matrix::getLength(){
    return length;
 }


float* Matrix::getData(){
    return data;
}

Matrix Matrix::operator+(Matrix &B){
    Matrix C(length);
    for (int i = 0; i < length; i ++){
        C.data[i] = data[i] + B.data[i];
    }
    return C;
}


/*******************************************************************************
* Matrix Matrix::operator+(float f)
* // overloads the + operator to allow us to add a 
* // float to every element of a Matrix object (ex. A + 2.2)

    float f: the float to be added
    returns the new matrix
********************************************************************************/
Matrix Matrix::operator+(float f){
    Matrix newM = Matrix(length); // creates a new matrix to store the computed values
    for (int i = 0; i < length; i++){
        newM.data[i] = data[i] + f; // adds the float to each value of the matrix
    }
    return newM; 
}

/*******************************************************************************
* Matrix operator+(float f, const Matrix& A)
* // overloads the + operator to allow us to add a 
* // float to every element of a Matrix object (ex. 2.2 + A)

    float f: the float to be added
    const Matrix& A: reference to the Matrix we'll be using for this operation
    returns the new matrix
********************************************************************************/
Matrix operator+(float f, const Matrix& A){

    Matrix newM = Matrix(A.length); // creates a new matrix to store the computed values
    for (int i = 0; i < A.length; i++){
        newM.data[i] = f + A.data[i]; // adds the float to each value of the matrix
    }
    return newM;
}

/*******************************************************************************
* ostream& operator<<(ostream& os, const Matrix& A)
* // overloads the << operator to allows you to use <<
* // to print a matrix object (ex. cout << A)

    float f: the float to be added
    const Matrix& A: reference to the Matrix we'll be using for this operation
    returns the new matrix
********************************************************************************/
ostream& operator<<(ostream& os, const Matrix& A){
    for (int i = 0; i < A.length; i++){ // loops through the entire matrix and prints it out value by value
        os << A.data[i];
        os << " ";
    }
    return os; //returns our final output
} 
