import java.util.LinkedList;

public class InitialRound extends AbsRound implements IWinner {
	
	public InitialRound(LinkedList<Match> matches) {
		super(matches);
	}
	
	/**
	 * goes through a list of matches in a round and checks to see that the contestant was a winner in at least one of the matches that makes up that round.
	 * @param checkedCont a contestant who might be a winner.
	 * @return whether that contestant is a winner.
	 */
	public boolean isWinner(IContestant checkedCont) {
		
		for (Match match : matches) {
			if (match.winner() == null){
				return false;
			}
			else if (match.winner().equals(checkedCont)) {
				return true;
			}
		} return false;
	}
}
