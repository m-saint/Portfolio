import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IReport { // manages the data structure for a collection of daily weather reports
	
	double addUp(LinkedList<Double> datalist);
	public double averageDayTemp();
	public double totalDayRainfall();
	public GregorianCalendar getDate();
	public void addTemp(double temp);
	public void addRainfall(double rainfall);

}
