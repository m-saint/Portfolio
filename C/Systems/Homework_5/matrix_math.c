#include "matrix_math.h"

/********************************************************
*   addition(Matrix A, Matrix B)
*    takes the two matrices and adds em together, prints out result
*   
*   Input:
*       A & B: matrices to be added
*   Returns:
*       nothin
*********************************************************/
void addition(Matrix A, Matrix B){

    // settin up our result matrix
    Matrix M; 
    M.size = A.size;
    float data[M.size];
    M.data = data;

    // doin the math and filling the result matrix 
    for (int i = 0; i < M.size; i++){
        M.data[i] = A.data[i] + B.data[i];
    }

    // printing it all out
    printf("A + B =\n    ");
    for (int j = 0; j < M.size; j++){
        printf("%.2f  ", M.data[j]);
    }
}

/********************************************************
*   subtraction(Matrix A, Matrix B)
*    takes the two matrices and subtracts one from the other, prints out result
*   
*   Input:
*       A & B: matrices to be subtracted (A-B)
*   Returns:
*       nothin
*********************************************************/
void subtraction(Matrix A, Matrix B){

    // settin up our result matrix
    Matrix M; 
    M.size = A.size;
    float data[M.size];
    M.data = data;

    // doin the math and filling the result matrix 
    for (int i = 0; i < M.size; i++){
        M.data[i] = A.data[i] - B.data[i];
    }

    // printing it all out
    printf("A - B =\n    ");
    for (int j = 0; j < M.size; j++){
        printf("%.2f  ", M.data[j]);
    }
    
}

/********************************************************
*   average(Matrix A, Matrix B)
*    takes the two matrices and finds the average matrix between em, prints out result
*   
*   Input:
*       A & B: matrices to be averaged
*   Returns:
*       nothin
*********************************************************/
void average(Matrix A, Matrix B){

    // settin up our result matrix
    Matrix M; 
    M.size = A.size;
    float data[M.size];
    M.data = data;

    // doin the math and filling the result matrix 
    for (int i = 0; i < M.size; i++){
        M.data[i] = A.data[i] + B.data[i];
        M.data[i] = M.data[i] / 2;
    }

    // printing it all out
    printf("Average of A & B =\n    ");
    for (int j = 0; j < M.size; j++){
        printf("%.2f  ", M.data[j]);
    }
    
}