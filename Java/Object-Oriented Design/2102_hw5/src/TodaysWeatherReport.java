import java.util.GregorianCalendar;
import java.util.LinkedList;

public class TodaysWeatherReport implements IReport {
	
	private GregorianCalendar date;
	private LinkedList<Double> temps;
	private LinkedList<Double> rainfalls;
	
	public TodaysWeatherReport(GregorianCalendar date, LinkedList<Double> temps, LinkedList<Double> rainfalls){
		this.date = date;
		this.temps = temps;
		this.rainfalls = rainfalls;
	}
	
	public double addUp(LinkedList<Double> datalist) {
		double total = 0;
		for (double data : datalist) {
			total += data;
		}
		return total;
	}
	
	public double averageDayTemp() {
		
		double total = addUp(temps);
		total /= temps.size();
		return total;
	}
	
	public double totalDayRainfall() {
		return addUp(rainfalls);
	}

	public GregorianCalendar getDate() {
		return date;
	}
	
	public void addTemp(double temp) {
		this.temps.add(temp);
	}
	
	public void addRainfall(double rainfall) {
		this.rainfalls.add(rainfall);
	}
	
	

}
