import java.util.LinkedList;

/**
 * a class used to hold the dailyMaxForMonth method and associated helpers
 * @version 1
 * @author mstje
 */
class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 /**
  * finds the highest frequency reading for each day in a month 
  * @param data a list of doubles representing sensor data 
  * @param month a number from 1 to 12 representing the month of the data we want
  * @return a list of reports indicating the maximum frequency for each day in that month
  */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
   LinkedList<MaxHzReport> listOfReports = new LinkedList<MaxHzReport>();
   LinkedList<Integer> datePositions = new LinkedList<Integer>(); // indexes in list"data" where a date in the given "month" is located
   
   for (int i = 0; i < data.size(); i++) {
	   if (isDate(data.get(i))) {
		   if (extractMonth(data.get(i)) == month) {
			  datePositions.add(i);
		   }
	   } 
   }
   
   for (int j = 0; j < data.size(); j++) {
	   for (int k = 0; k < datePositions.size(); k++) {
		   if (j == datePositions.get(k)){
			   LinkedList<Double> dataGroup = new LinkedList<Double>();
			   int l = j;
			   do {								// forces it to add the date we want
				   dataGroup.add(data.get(l));
				   l++;
				   if ( l >= data.size()) {     // prevents out of bounds errors because l increments before the conditional
					   break;
				   }
			   } while (isDate(data.get(l)) == false); // loops until it comes across another date in list"data"
			   
			   double currentMax = -1;
			   for (int m = 1; m < dataGroup.size(); m++) {
				   if (dataGroup.get(m) <= 500 && dataGroup.get(m) >= 0 && dataGroup.get(m) > currentMax) {
					   currentMax = dataGroup.get(m);
				   } 
				   
			   }
			   
			   MaxHzReport report = new MaxHzReport(data.get(j), currentMax);
			   listOfReports.add(report);
		   }
	   }
   } return listOfReports;
  }
  
}  

