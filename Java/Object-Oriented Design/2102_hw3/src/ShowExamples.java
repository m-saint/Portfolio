import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	LinkedList<Show> shows = new LinkedList<Show>();
	LinkedList<Show> shows2 = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	ShowSummary myReport = new ShowSummary();

	Show startrek = new Show("Star Trek", 1800, 45.0, false);
	Show futurama = new Show("Futurama", 1900, 23.0, false);
	Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
	Show sesamestreet = new Show("Sesame Street", 900, 60.0, false);
	
	Show earlyShow = new Show("why are you awake", 600, 4.0, false);
	Show secretShow = new Show("shh", 101, 1440.0, false);
	Show boringShow = new Show("yawn", 1738, 0.1, false);
	Show coolShow = new Show("super cool show", 1000, 61.0, true);
	Show lateShow = new Show("go to bed", 30, 42, false);

	public ShowExamples()
	{
		shows.add(startrek);
		report1.primetime.add(startrek);

		shows.add(futurama);
		report1.primetime.add(futurama);

		shows.add(animaniacs);
		report1.daytime.add(animaniacs);

		shows.add(sesamestreet);
		report1.daytime.add(sesamestreet);
		
		shows2.add(boringShow);
		myReport.primetime.add(boringShow);
		
		shows2.add(coolShow);
		
		shows2.add(earlyShow);
		myReport.daytime.add(earlyShow);
		
		shows2.add(secretShow);
		
		shows2.add(lateShow);
		myReport.latenight.add(lateShow);
		
		
	}
	
	@Test
	public void instructorTestShowSummary_EmptyReport() {
		ShowSummary report2 = new ShowSummary();
		assertFalse(report1.equals(report2));
	}
	
	@Test
	public void TestShowSummary_EmptyReport2() {
		ShowSummary report2 = new ShowSummary();
		ShowSummary report3 = new ShowSummary();
		assertTrue(report3.equals(report2));
	}


	@Test
	public void instructorTestShowSummary_WrongOrder() {
		ShowSummary report2 = new ShowSummary();

		report2.primetime.add(futurama);
		report2.primetime.add(startrek);
		report2.daytime.add(animaniacs);
		report2.daytime.add(sesamestreet);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_DifferentInstances() {
		ShowSummary report2 = new ShowSummary();

		Show startrek2 = new Show("Star Trek", 1800, 60.0, true);
		Show futurama2 = new Show("Futurama", 1900, 20.0, false);
		Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
		Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

		report2.primetime.add(startrek2);
		report2.primetime.add(futurama2);
		report2.daytime.add(animaniacs2);
		report2.daytime.add(sesamestreet2);

		assertTrue(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_SameInstances() {
		ShowSummary report2 = report1;
		assertTrue(report1.equals(report2));
	}
	
	@Test
	public void TestShowSummary_TotallyDifferent() {
		ShowSummary report2 = new ShowSummary();
		
		report2.latenight.add(secretShow);
		report2.daytime.add(earlyShow);
		report2.daytime.add(coolShow);
		report2.primetime.add(boringShow);
		
		assertFalse(report2.equals(report1));
	}


	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	
	@Test
	public void TestOrganizeShows2() 
	{
		ShowSummary report2 = sm1.organizeShows(shows2);
		assertEquals(myReport, report2);
	}
	
	@Test
	public void TestOrganizeShowsSpecialAndOvernight() 
	{
		ShowSummary report2wStuff = new ShowSummary();
		report2wStuff.primetime.add(boringShow);
		report2wStuff.daytime.add(coolShow);
		report2wStuff.daytime.add(earlyShow);
		report2wStuff.latenight.add(secretShow);
		report2wStuff.latenight.add(lateShow);
		
		ShowSummary report2 = sm1.organizeShows(shows2);
		
		assertFalse(report2wStuff.equals(report2));
	}

}

/*
 	Q1 SUBTASKS
	checking if a show is a special
	checking what time category a show falls into
	separating shows into lists based on their time category
	making a ShowSummary with these three lists
 */

