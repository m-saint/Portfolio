import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake2 E2 = new Earthquake2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<Double> dates = new LinkedList<Double>(); 
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> JanReports = new LinkedList<MaxHzReport>();
  
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    
    dates.add(20111007.0);
    dates.add(40.0);
    dates.add(20111013.0);
    dates.add(-40.0);
    dates.add(5.5);
    dates.add(20111020.0);
    dates.add(501.0);
    dates.add(50.01);
    dates.add(0.25);
    dates.add(20111101.0);
    dates.add(40.0);
    OctReports.add(new MaxHzReport(20111007.0,40.0));
    OctReports.add(new MaxHzReport(20111013.0,5.5));
    OctReports.add(new MaxHzReport(20111020.0,50.01));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }
  
  @Test
  public void EQTest() { 
    assertEquals(OctReports, 
                 E1.dailyMaxForMonth(dates, 10));
  }
  
  @Test
  public void EQTestNoneOfMonth() { 
    assertEquals(JanReports, 
                 E1.dailyMaxForMonth(dates, 01));
  }
  
  @Test
  public void EQTestEmptyData() { 
    assertEquals(JanReports, 
                 E1.dailyMaxForMonth(noData, 01));
  }
  
  @Test
  public void instructorTestEQQ() { 
    assertEquals(NovReports, 
                 E2.dailyMaxForMonth(threeDates, 11));
  }
  
  @Test
  public void EQTestt() { 
    assertEquals(OctReports, 
                 E2.dailyMaxForMonth(dates, 10));
  }
  
  @Test
  public void EQTestNoneOfMonthh() { 
    assertEquals(JanReports, 
                 E2.dailyMaxForMonth(dates, 01));
  }
  
  @Test
  public void EQTestEmptyDataa() { 
    assertEquals(JanReports, 
                 E2.dailyMaxForMonth(noData, 01));
  }

}

/*
 	Q2 SUBTASKS
 	finding the dates in the given month
 	getting the readings associated with each date
 	finding the greatest of the readings for each date
 	making a report for each day's date and max reading
 	adding each report to a list
 */
