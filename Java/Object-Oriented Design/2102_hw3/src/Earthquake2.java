import java.util.LinkedList; 

/**
 * a class used to hold the dailyMaxForMonth method and associated helpers 
 * @version 2
 * @author mstje
 */
class Earthquake2 {
  Earthquake2(){}
      
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
 
 LinkedList<MaxHzReport> L2 = new LinkedList<MaxHzReport>();
 
 for(int j = 0; j < data.size(); j++) {
LinkedList<Double> L1 = new LinkedList<Double>();
 if(isDate(data.get(j)) == true && extractMonth(data.get(j)) == month) {
	 
 
 L1.add(data.get(j));
 for(int k = j +1; k < data.size(); k++ ) {
 if(isDate(data.get(k)) == false) {
 L1.add(data.get(k));
 } else {
 break;
 }
 } 
 double currentMax = -1;
 
 for(int l = 1; l < L1.size(); l++) {
	 if(L1.get(l) > currentMax && L1.get(l) >= 0 && L1.get(l) <= 500) {
	 currentMax = L1.get(l);
	 }  
	 }
	 MaxHzReport report = new MaxHzReport(L1.get(0), currentMax);
	 L2.add(report); 
 }
 }
 return L2;
  }
}
