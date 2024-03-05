#include <stdio.h>
// Function prototypes
// You may modify these
int get_year_start(int);            // takes year, returns day that year starts on
void printCalendar(int, int);       // takes year and start day, prints 12 months
int printMonth(int, int, int);      // takes year, month and start day of month, prints 1 month, returns start of next month
int printMonthName(int, int);       // takes year and month number, prints header for that month, returns number of days in month

int main(void){

    int year;

    printf("Please enter year for this calendar: ");
    scanf("%d", &year);
    printf("\n***    CALENDAR for %d   ***\n\n", year);

    int startDayNum = get_year_start(year);

    printCalendar(year, startDayNum);
}

/********************************************************
*   get_year_start()
*   Determines the day of the week that the specified
*   year starts on. Uses current calendar rules (ignores calendar changes)
*   Input:
*       year: the year being studied
*   Returns:
*       The day of the week the year starts on
*       0: Sunday, 1: Monday, etc
*   Source:
*       https://stackoverflow.com/questions/478694/what-is-the-easiest-algorithm-
to-find-the-day-of-week-of-day-zero-of-a-given-year
*********************************************************/
int get_year_start(int year){
    int year_start =  (((year-1) * 365) + ((year-1) / 4) - ((year-1) / 100) + 
((year-1) / 400) + 1) % 7;
    return year_start;
}

/********************************************************
*   printCalendar(in year, int day)
*   Prints 1 year of a calendar
*   
*   Input:
*       year: the year being studied
*       day: the day of the week that the year starts on
*   Returns:
*       Nothing
*   Calls: printMonth
*********************************************************/
void printCalendar(int year, int day){

    int monthStartDay = day;

    for ( int i = 0; i < 12; i++){
       monthStartDay = printMonth(year, i, monthStartDay);
    }
    
}

/********************************************************
*   printMonth(int year, int month, int start_day)
*   Prints 1 month of a calendar, returns the start of the next month
*   
*   Input:
*       year: the year being studied
*       month: the month to be printed
*       start_day: the day of the week that the month starts on
*   Returns:
*       The start day of the next month
*   Calls: printMonthName
*********************************************************/
int printMonth(int year, int month, int start_day){
    
    int numDaysInMonth = printMonthName(year, month);

    for (int i = 0; i < start_day; i++){
        printf("     ");
    }

    int dayOfWeek = start_day;

    for (int i = 1; i <= numDaysInMonth; i++){
        if (dayOfWeek == 7){
            printf("\n");
            printf("%5d", i);
            dayOfWeek = 1;
        }
        else {
            printf("%5d", i);
            dayOfWeek++;
        }
       
    }

    printf("\n"); printf("\n");

    if (dayOfWeek == 7){
        dayOfWeek = 0;
    }
    return dayOfWeek;

}

/********************************************************
*   printMonthName(int year, int month)
*   prints header for the month, returns number of days in month
*   
*   Input:
*       year: the year being studied
*       month: the month to be printed
*   Returns:
*       The number of days in the month
*********************************************************/
int printMonthName(int year, int month){

   int num_days;
    switch (month+1) {
    case 1:
        printf("January %d\n", year); 
        num_days = 31;
        break;
    case 2:
        printf("February %d\n", year); 

       if (year % 4 == 0){
        if (year % 100 == 0){
            if (year % 400 == 0){
                num_days = 29;
            }
            else {
                num_days = 28;
            }
        }
        else {
            num_days = 29;
        }
       }
       else {
        num_days = 28;
       }
        break;
    case 3:
        printf("March %d\n", year); 
        num_days = 31;
        break;
    case 4:
        printf("April %d\n", year); 
        num_days = 30;
        break;
    case 5:
        printf("May %d\n", year);
        num_days = 31; 
        break;
    case 6:
        printf("June %d\n", year);
        num_days = 30; 
        break;
    case 7:
        printf("July %d\n", year); 
        num_days = 31;
        break;
    case 8:
        printf("August %d\n", year); 
        num_days = 31;
        break;
    case 9:
        printf("September %d\n", year); 
        num_days = 30;
        break;
    case 10:
        printf("October %d\n", year); 
        num_days = 31;
        break;
    case 11:
        printf("November %d\n", year);
        num_days = 30; 
        break;
    case 12:
        printf("December %d\n", year); 
        num_days = 31;
        break;
    default:
        printf("That's no month");
        break;
    }

    printf("\n  Sun  Mon  Tue  Wed  Thu  Fri  Sat\n");

    return num_days;
}