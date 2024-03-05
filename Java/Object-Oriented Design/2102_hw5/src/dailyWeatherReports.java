import java.util.GregorianCalendar;
import java.util.LinkedList;

public class dailyWeatherReports implements IDailyWeatherReports {
	
	private LinkedList<IReport> reports;
	
	public dailyWeatherReports() {
		this.reports = new LinkedList<IReport>();
	}
	
	public void addReport(IReport report) {
		this.reports.add(report);
	}
	
public double averageMonthTemp(int month, int year) {
		
		double total = 0;
		int acc = 0; 
		
		for (IReport report : reports) {
			if (report.getDate().get(GregorianCalendar.MONTH) == month &&
				    report.getDate().get(GregorianCalendar.YEAR) == year) {
						total += report.averageDayTemp();
						acc++;
					}
		} 
		
		if (acc > 0) return total / acc;
		else return -666666666;
	}

public double totalMonthRainfall(int month, int year) {
	
	double total = 0;
	
	for (IReport report : reports) {
		if (report.getDate().get(GregorianCalendar.MONTH) == month &&
			    report.getDate().get(GregorianCalendar.YEAR) == year) {
					total += report.totalDayRainfall();
				}
	} return total;
}

public void addTodaysReport(GregorianCalendar date, LinkedList<Reading> readings) {
	IReport report = new TodaysWeatherReport(date, new LinkedList<Double>(), new LinkedList<Double>());
	for (Reading reading : readings) {
		report.addTemp(reading.getTemp());
		report.addRainfall(reading.getRainfall());
	}
	this.reports.add(report);
}

}
