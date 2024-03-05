#include <stdio.h>
#include <stdlib.h>

struct matrix{
    int size;
    float* data;
};

typedef struct matrix Matrix;

void addition(Matrix, Matrix);
void subtraction(Matrix, Matrix);
void average(Matrix, Matrix);