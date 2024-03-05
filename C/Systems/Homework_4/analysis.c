#include <stdio.h>
#include <stdlib.h>
#include "sales_reports.h"

#define ITEMS 51

float* readCosts(int numItems);
float* readPurch(int numItems);

int main(int argc, char* argv[]){

    // allocate arrays to store argc-1 months of data
    int month_data[ITEMS][13];

    // initialize month_data to zeros
    for (int i = 0; i < 13; i ++){
        for (int j = 0; j < ITEMS; j++){
            month_data[j][i] = 0;
        }
    }

    int new_item;
    float cost;

    //loop over all months
    for (int i = 1; i < argc; i++){
        
        // open sales file

        FILE* f1 = fopen(argv[i], "r");

        // load sales data

        while(fscanf(f1, "%d %f", &new_item, &cost) > 0){
            month_data[new_item][i] = month_data[new_item][i] + 1;
            month_data[new_item][0] = new_item;
        }
        fclose(f1);

    } // end loop over months

    // call all 3 functions here

    float* costs = readCosts(ITEMS);
    float* purchases = readPurch(ITEMS);

    get_totals(month_data, ITEMS, argc-1);
    get_profits(month_data, ITEMS, argc-1, costs, purchases);
    top_earner(month_data, ITEMS, argc-1, costs, purchases);

    free(costs);
    free(purchases);
    
}

/********************************************************
*   readCosts(int numItems)
*   reads the Costs column of the the Costs.txt file into an array. 
*   
*   Input:
*       numItems: the total number of items
*   Returns:
*       a pointer to the memory where the cost values are stored
*********************************************************/

float* readCosts(int numItems){
    float* costs = calloc(numItems, sizeof(float));

    FILE* f2 = fopen("Costs.txt", "r");
    int new_item;
    float purchase;
    float cost;

    while(fscanf(f2, "%i %f %f", &new_item, &purchase, &cost) > 0){
        costs[new_item] = cost;
    }
    fclose(f2);

    return costs;

}

/********************************************************
*   readPurch(int numItems)
*   reads the Purchase column of the the Costs.txt file into an array. 
*   
*   Input:
*       numItems: the total number of items
*   Returns:
*       a pointer to the memory where the purchase values are stored
*********************************************************/

float* readPurch(int numItems){
    float* purchases = calloc(numItems, sizeof(float));

    FILE* f2 = fopen("Costs.txt", "r");
    int new_item;
    float purchase;
    float cost;

    while(fscanf(f2, "%i %f %f", &new_item, &purchase, &cost) > 0){
        purchases[new_item] = purchase;
    }
    fclose(f2);

    return purchases;

}