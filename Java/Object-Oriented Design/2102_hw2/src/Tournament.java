import java.util.LinkedList;

public class Tournament {
	
	LinkedList<IWinner> rounds = new LinkedList<IWinner>();
	
	public Tournament(LinkedList<IWinner> rounds) {
		this.rounds = rounds;
	}
	
	/**
	 * goes through a list of rounds and checks if the contestant has one more than half of them.
	 * @param checkedCont a contestant representing the tournament winner
	 * @return whether that contestant is a winner.
	 */
	boolean finalWinnerIsValid(IContestant checkedCont) {
		int acc = 0;
		
		for (IWinner round : this.rounds) {
			if (round.isWinner(checkedCont) == true) {
				acc++;
			}
		}
		return (acc > (this.rounds.size()/2));
	}
}

