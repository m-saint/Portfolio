#include <stdio.h>
#include "pos_programs.h"

// calc all rev
// Reads the file and calculates the overall revenue for the day. 
float calcAllRev(char inFile[50]){

    FILE* inSplore = fopen(inFile, "r"); // we're running through the file ahead of time to check how long it is
    int count = 0; // stores how many lines of input we're getting
    
    // loops through the whole file char by char until we hit the endoffile, and if it finds a newline, that indicates that there's a new line (wow) and we increment the counter
    for (int search = fgetc(inSplore); search != EOF; search = fgetc(inSplore)){
        if (search == '\n'){ 
            count++;
        }
    }

    count++; // accounts for the last line of input since there's not a newline at the end of the file

    fclose(inSplore);

    FILE* in = fopen(inFile, "r"); // start fresh

    float rev = 0.00; 
    float junk; 

    // we don't want the item code 0 or the initial balance
    fscanf(in, "%f", &junk);
    fscanf(in, "%f", &junk);

                       
    for (int i = 1; i < count; i++){ // using our count from earlier so we know how many lines of input to loop through
        int code;
        float cost;
        fscanf(in, "%d", &code); // skip over the item code to get to the good stuff (only care about second column)
        fscanf(in, "%f", &cost);
        rev += cost;
    }

    fclose(in);
    return rev;

}



// calc reg bal
// Reads the file and calculates the balance in the cash register at the end of the day. 
float calcRegBal(char inFile[50]){

    FILE* inSplore = fopen(inFile, "r"); // we're running through the file ahead of time to check how long it is
    int count = 0; // stores how many lines of input we're getting
    
    // loops through the whole file char by char until we hit the endoffile, and if it finds a newline, that indicates that there's a new line (wow) and we increment the counter
    for (int search = fgetc(inSplore); search != EOF; search = fgetc(inSplore)){
        if (search == '\n'){ 
            count++;
        }
    }

    count++; // accounts for the last line of input since there's not a newline at the end of the file

    fclose(inSplore);

    FILE* in = fopen(inFile, "r"); // start fresh

    float bal;
                       
    for (int i = 0; i < count; i++){ // using our count from earlier so we know how many lines of input to loop through
        int code;
        float cost;
        fscanf(in, "%d", &code); // skip over the item code to get to the good stuff (only care about second column)
        fscanf(in, "%f", &cost);
        bal += cost;
    }

    fclose(in);
    return bal;
    
}



// calc item sales
// Reads the file and tallies the number of times a particular item was sold and the total revenue from that item. 
int calcItemSales(char inFile[50], int itemToAnal){

    FILE* inSplore = fopen(inFile, "r"); // we're running through the file ahead of time to check how long it is
    int count = 0; // stores how many lines of input we're getting
    
    // loops through the whole file char by char until we hit the endoffile, and if it finds a newline, that indicates that there's a new line (wow) and we increment the counter
    for (int search = fgetc(inSplore); search != EOF; search = fgetc(inSplore)){
        if (search == '\n'){ 
            count++;
        }
    }

    count++; // accounts for the last line of input since there's not a newline at the end of the file

    fclose(inSplore);

    FILE* in = fopen(inFile, "r");

    int num = 0;
    float itemCost;

    for (int i = 0; i < count; i++){ // using our count from earlier so we know how many lines of input to loop through
        int code;
        float cost;
        fscanf(in, "%d", &code); 
        fscanf(in, "%f", &cost);
        
        if (code == itemToAnal){
            num++;
            itemCost = cost;
        }
    }

    fclose(in);
    return num;

}