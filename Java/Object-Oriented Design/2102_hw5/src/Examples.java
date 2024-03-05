import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class Examples {

	LinkedList<Double> temps1 = new LinkedList<Double>();
	LinkedList<Double> rainfalls1 = new LinkedList<Double>();
	Time sixAM = new Time(7, 0);
	Time eightPM = new Time(20, 0);
	Time twoThirtyPM = new Time(14, 30);
	Time midnight = new Time (0, 0);
	Reading reading1 = new Reading(sixAM, 42.25, 3.5);
	Reading reading2 = new Reading(eightPM, 52, 1.0);
	Reading reading3 = new Reading(twoThirtyPM, 42.25, 0.0);
	Reading reading4 = new Reading(midnight, 42.25, 1.25);
	LinkedList<Reading> readings = new LinkedList<Reading>();

	
	@Before
	public void setup() {
		temps1.add(50.0);
		temps1.add(40.0);
		temps1.add(45.0);
		temps1.add(55.5);
		rainfalls1.add(4.0);
		rainfalls1.add(0.1);
		rainfalls1.add(0.3);
		rainfalls1.add(0.2);
		
		readings.add(reading1);
		readings.add(reading2);		
		readings.add(reading3);
		readings.add(reading4);
		



	}
	
	GregorianCalendar oct172002 = new GregorianCalendar(2002, 9, 17);
	GregorianCalendar oct252002 = new GregorianCalendar(2002, 9, 25);
	GregorianCalendar jan132019 = new GregorianCalendar(2019, 0, 13);
	GregorianCalendar mar142020 = new GregorianCalendar(2020, 2, 14);
	GregorianCalendar mar312020 = new GregorianCalendar(2020, 2, 31);
	IReport dwrOct172002 = new TodaysWeatherReport(oct172002, temps1, rainfalls1);
	WeatherStation station1 = new WeatherStation(dwrOct172002);
	
	@Test
	public void test() {
		station1.addTodaysReport(oct252002, readings);
		station1.addTodaysReport(jan132019, readings);
		station1.addTodaysReport(mar142020, readings);
		station1.addTodaysReport(mar312020, readings);
		
		assertEquals(station1.averageMonthTemp(9,2002), 46.15625, 0);
		assertEquals(station1.averageMonthTemp(0,2019),44.6875, 0);
		assertEquals(station1.averageMonthTemp(11,2004), -666666666, 0);

		assertEquals(station1.totalMonthRainfall(2, 2020), 11.5,0);
		assertEquals(station1.totalMonthRainfall(9, 2002), 10.35,0);
		assertEquals(station1.totalMonthRainfall(8, 2099), 0,0);
		
	}

}
