
public class SoccerTeam implements IContestant {
	
	String country;
	String jersey;
    boolean ritual;
	int wins;
	int losses;
	
	SoccerTeam (String country, String jersey, Boolean ritual, int wins, int losses) {
		this.country = country;
		this.jersey = jersey;
		this.ritual = ritual;
		this.wins = wins;
		this.losses = losses;
	}
	
	boolean expectToBeat(SoccerTeam opponent) {
		if (this.ritual== true && opponent.ritual == false) {
			return true;
		} else if (this.ritual == false && opponent.ritual == true) {
			return false;
		} else if ( (this.wins - this.losses) > (opponent.wins - opponent.losses)) {
			return true;
		} else if ( (this.wins - this.losses < (opponent.wins - opponent.losses))) {
			return false;
		} else return false;
	}
	
	

}
