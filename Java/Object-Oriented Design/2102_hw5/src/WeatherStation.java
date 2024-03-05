import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherStation {
	
	private IDailyWeatherReports reports = new dailyWeatherReports(); // *uses an interface type*
	
	public WeatherStation(IReport todaysReport){ // takes interface type as argument
		this.reports.addReport(todaysReport);
	}
	
public double averageMonthTemp(int month, int year) {
		
		return this.reports.averageMonthTemp(month, year);
	}
	
	public double totalMonthRainfall(int month, int year) {
		
		return this.reports.totalMonthRainfall(month, year);
	}
	
	public void addTodaysReport(GregorianCalendar date, LinkedList<Reading> readings) {
		this.reports.addTodaysReport(date, readings);
	}
	 
	
	

}
