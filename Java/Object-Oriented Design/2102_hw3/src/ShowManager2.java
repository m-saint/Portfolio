import java.util.LinkedList; 

/**
 * a class used to hold the organizeShows method
 * @version 2
 * @author mstje
 */
class ShowManager2 {
ShowManager2() {}

/**
 * Organizes non-special shows into a report based on the time they start
 * @param shows the list of Shows to be organized
 * @return a ShowSummary of three lists of Shows of the same time category
 */
public ShowSummary organizeShows(LinkedList<Show> shows) {
LinkedList<Show> daytime = new LinkedList<Show>();
LinkedList<Show> primetime = new LinkedList<Show>();
LinkedList<Show> latenight = new LinkedList<Show>();
for(Show show : shows) {
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
for(Show dayshows : daytime) {
if(dayshows.isSpecial == true) {
daytime.remove(dayshows);
}
}
for(Show primeshows : primetime) {
if(primeshows.isSpecial == true) {
primetime.remove(primeshows);
}
}
for(Show nightshows : latenight) {
if(nightshows.isSpecial == true) {
latenight.remove(nightshows);
}
}
ShowSummary organizedShows = new ShowSummary(daytime, primetime, latenight);
return organizedShows;
}
}
