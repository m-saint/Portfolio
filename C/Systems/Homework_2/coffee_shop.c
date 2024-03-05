#include <stdio.h>
#include "pos_programs.h"

// asks which of the 3 options to run
// asks for relevant parameters
// run the corresponding function and output accordingly
int main(void){

    int progToRun;
    char inFile[50];

    printf("Which program would you like to run: (1) Calculate overall revenue, (2) Calculate register balance, or (3) Calculate sales for an item.\n");
    scanf("%d", &progToRun);
    printf("Please enter an input file:\n");
    scanf("%s", inFile);

    switch(progToRun){

        case 1: 
            printf("%.2f\n", calcAllRev(inFile));
            break;
            
        case 2: 
            printf("%.2f\n", calcRegBal(inFile));
            break;
            
        case 3: 
            int itemToAnal; 
            char outFile[50];
            char appOrOver;
            printf("Which item to analyze?\n");
            scanf("%d", &itemToAnal);
            printf("What is the output file?\n");
            scanf("%s", outFile);
            printf("Enter A for Append or O for over-write.\n");
            scanf(" %c", &appOrOver);

            int num = calcItemSales(inFile, itemToAnal);

            if (appOrOver == 'A'){
                FILE* out = fopen(outFile, "a");
                fprintf(out, "  %d", itemToAnal);
                fprintf(out, "   %d\n", num);
                fclose(out);
            }
            else if (appOrOver == 'O'){
                FILE* out = fopen(outFile, "w");
                fprintf(out, "  %d", itemToAnal);
                fprintf(out, "   %d\n", num);
                fclose(out);
            }
            else {
                printf("This option is not valid.");
            }

            break;

        default:
            printf("This option is not valid.");
    }   

}