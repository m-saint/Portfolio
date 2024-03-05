#include "matrix_math.h"

Matrix* readMatrix(char* filename); 
int deleteMatrix(Matrix* M); 

int main(int argc, char* argv[]){

    // get our matrices ready
    Matrix* A = readMatrix(argv[1]);
    Matrix* B = readMatrix(argv[2]);

    // make sure we're gonna be able to do the math
    if ( (*A).size != (*B).size){
        printf("This math cannot be performed.");
        return 1;
    }

    // checking argument so we run the right operation

    if (*argv[3] == 'a'){
        addition(*A, *B);
    }

    else if (*argv[3] == 's'){
        subtraction(*A, *B);
    }

    else if (*argv[3] == 'n'){
        average(*A, *B);
    }

    else {
        printf("This math cannot be performed."); 
    }

    // deleting our matrices (wow)
    deleteMatrix(A);
    deleteMatrix(B);

}

/********************************************************
*   readMatrix(char* filename)
*    reads in the input file and allocate the array in the matrix struct.
*   
*   Input:
*       filename: the name of the file (shocker)
*   Returns:
*       a pointer to the memory where the matrix struct is stored
*********************************************************/
Matrix* readMatrix(char* filename){

    FILE* in = fopen(filename, "r"); // open input file

    Matrix* M = malloc(sizeof(Matrix)); // allocate some memory for this matrix

    fscanf(in, "%d", &M->size); // check what size we're workin with (first line in input file)

    float* data = malloc(M->size*sizeof(float)); // allocate some memory to store the actual values within our struct
    M->data = data;

    for (int i = 0; i < M->size; i++){
        fscanf(in, "%f", &M->data[i]); // scan thru the file, store the values in the array we made
    }

    fclose(in);
    return M;
}

/********************************************************
*   deleteMatrix(Matrix* M)
*    deletes the matrix 
*   
*   Input:
*       M: pointer to matrix to be deleted
*   Returns:
*       nothin
*********************************************************/
int deleteMatrix(Matrix* M){
    free(M); // frees memory omg
}