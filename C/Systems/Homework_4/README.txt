analysis.c and sales_reports.c and sales_reports.h and makefile
Myles St. Jean
2/14/23

- Reads in the sales reports for the last m months. 
- Stores the data in a 50xm+1 array of ints where the first column is the item code and the next m 
  columns are the data for each month. 
- Uses two 50x1 arrays of floats to store the cost and 
  the price of each item. 

details: 
- takes a variable number of command line arguments
- splits money into two 1D arrays, one for each column
- creates Total_sales.txt that contains a list of each item 
  and the total number of sales for the item. file the item-specific revenue
- create Profits.txt that contains the total sales, total cost, 
  amount earned and profit for each item (cost – sales price)*items sold  
- creates Top_earners.txt which lists the 10 items with the highest revenue.  

To compile:
gcc -o analysis.exe analysis.c sales_reports.c
or
make analysis

To run:
./analysis.exe

sources: just me and obv the starter code 
