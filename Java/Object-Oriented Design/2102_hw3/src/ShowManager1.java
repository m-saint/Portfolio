import java.util.LinkedList;

/**
 * a class used to hold the organizeShows method
 * @version 1
 * @author mstje
 */
class ShowManager1 {
	
	ShowManager1() {}
/**
 * Organizes non-special shows into a report based on the time they start
 * @param shows the list of Shows to be organized
 * @return a ShowSummary of three lists of Shows of the same time category
 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> daytime = new LinkedList<Show>();
		LinkedList<Show> primetime = new LinkedList<Show>();
		LinkedList<Show> latenight = new LinkedList<Show>();

		for (Show show : shows) {
			if (show.isSpecial == false) {
				if(show.broadcastTime >= 600 && show.broadcastTime < 1700) {
					daytime.add(show);
				}
				else if (show.broadcastTime >= 1700 && show.broadcastTime < 2200) {
					primetime.add(show);
				}
				else if (show.broadcastTime >= 2200 || show.broadcastTime < 100) {
					latenight.add(show);
				}
			}
		} 
		ShowSummary organizedShows = new ShowSummary(daytime, primetime, latenight);
		return organizedShows;
	}
	
}
