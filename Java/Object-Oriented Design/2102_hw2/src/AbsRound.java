import java.util.LinkedList;

public abstract class AbsRound implements IWinner {
	
	LinkedList<Match> matches;
	
	public AbsRound(LinkedList<Match> matches) {
		this.matches = matches;
	}
	
	/**
	 * goes through a list of matches and adds the winner of each of those matches to a list.
	 * @return  a LinkedList of all of the contestants that won each match in each round.
	 */
	LinkedList<IContestant> getMatchWinners() {
		
		LinkedList<IContestant> listOfCont = new LinkedList<IContestant>();
		
		for (Match match : this.matches) {
			if (match.winner() != null) {
			listOfCont.add(match.winner());
			}
		}
		return listOfCont;
	}

	/**
	 * goes through a list of matches and counts up the winners.
	 * @return the number of winners in the round. 
	 */
	int getNumWinners() {
		
		int numWinners = 0;
		
		for (Match match : this.matches) {
			if (match.winner() != null){
				numWinners++;
			}
		}
		return numWinners;
	}

}
