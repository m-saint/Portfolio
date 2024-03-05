#include "sales_reports.h"
#include <stdio.h>


/********************************************************
*   get_totals(int month_data[][7], int items, int months)
*   creates Total_sales.txt that contains a list of each item and the total number of sales for the item. 
*   
*   Input:
*       month_data: sales for each month
*       items: the total number of items 
*       months: the number of months of data
*   Returns:
*       nothin
*********************************************************/
void get_totals(int month_data[][7], int items, int months){

    FILE* out = fopen("Total_sales.txt", "w");

    for (int i = 0; i < items; i++){
        int numSold = 0; // keeps track of how many of each item we sold
        for (int j = 1; j <= months; j++){
            numSold += month_data[i][j]; // adds all the sales for each month
        }
        fprintf(out, "%2d     %2d\n", month_data[i][0], numSold);
    }

    fclose(out);

}


/********************************************************
*   get_profits(int month_data[][7], int items, int months, float money[][2])
*   creates Profits.txt that contains the total sales, total cost, amount earned and profit for each item (cost – sales price)*items sold 
*   
*   Input:
*       month_data: sales for each month
*       items: the total number of items 
*       months: the number of months of data
*       money: the price and cost of each item
*   Returns:
*       nothin
*********************************************************/
void get_profits(int month_data[][7], int items, int months, float money[][2]){

    FILE* out = fopen("Profits.txt", "w");

    fprintf(out, "Item       #   Sales    Cost Revenue\n"); // lil header action

    for (int i = 1; i < items; i++){
        int numSold = 0; 
        for (int j = 1; j <= months; j++){
            numSold += month_data[i][j];
        }
        
        // relevant calculations
        float sales = numSold * money[i][0];
        float cost = numSold * money[i][1];
        float revenue = sales - cost;

        fprintf(out, "%4d      %2d   %5.2f   %5.2f   %5.2f\n", month_data[i][0], numSold, sales, cost, revenue);

    }

    fclose(out);

}


/********************************************************
*   top_earner(int month_data[][7], int items, int months, float money[][2])
*   creates Top_earners.txt which lists the 10 items with the highest revenue.  
*   
*   Input:
*       month_data: sales for each month
*       items: the total number of items 
*       months: the number of months of data
*       money: the price and cost of each item
*   Returns:
*       nothin
*********************************************************/
void top_earner(int month_data[][7], int items, int months, float money[][2]){

    float sortedEarners[items][3]; // an array to hold the item code, num sold, and revenue for each item, so we can sort it later

    for (int i = 1; i < items; i++){
        int numSold = 0;
        for (int j = 1; j <= months; j++){
            numSold += month_data[i][j];
        }
        
        float sales = numSold * money[i][0];
        float cost = numSold * money[i][1];
        float revenue = sales - cost;  
        
        // storing relevant data in the array
        sortedEarners[i][0] = i;
        sortedEarners[i][1] = numSold;
        sortedEarners[i][2] = revenue;
    }

    // loop through our list of codes/numsolds/revenues, check if the entry below the current one has greater revenue, 
    // if it does, swap those two entire rows, then back to the very start we go to. won't end til we make it through a complete run with no swaps
    for (int i = 0; i < items-1; i++){
        if (sortedEarners[i+1][2] > sortedEarners[i][2]){

            float temp = sortedEarners[i][0];
            sortedEarners[i][0] = sortedEarners[i+1][0];
            sortedEarners[i+1][0] = temp;

            float temp2 = sortedEarners[i][1];
            sortedEarners[i][1] = sortedEarners[i+1][1];
            sortedEarners[i+1][1] = temp2;

            float temp3 = sortedEarners[i][2];
            sortedEarners[i][2] = sortedEarners[i+1][2];
            sortedEarners[i+1][2] = temp3;

              i = -1; // back to start, it'll bump up to 0 when the loop increments so we gotta put -1
        }
    }

    // print out our array, but only the first 10 rows cuz that's all we care about

    FILE* out = fopen("Top_earners.txt", "w");

    fprintf(out, "Item   #  Revenue\n");

    for (int i = 0; i < 10; i++){
        fprintf(out, "%4.0f  ", sortedEarners[i][0]);
        fprintf(out, "%2.0f    ", sortedEarners[i][1]);
        fprintf(out, "%5.2f\n", sortedEarners[i][2]);
    }

    fclose(out);

}