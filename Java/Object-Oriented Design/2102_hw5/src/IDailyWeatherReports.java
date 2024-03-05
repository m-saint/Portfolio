import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IDailyWeatherReports {
	
	public void addReport(IReport report);
	
    public double averageMonthTemp(int month, int year);
    
    public double totalMonthRainfall(int month, int year);
    
    public void addTodaysReport(GregorianCalendar date, LinkedList<Reading> readings);

}
