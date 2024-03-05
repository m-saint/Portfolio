import java.util.LinkedList;

public class AdvancedRound extends AbsRound implements IWinner {
	
	LinkedList<IContestant> prevWinners = new LinkedList<IContestant>();
	
	public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> prevWinners) {
		super(matches);
		this.prevWinners = prevWinners;
	}
	
	/**
	 * goes through a list of previous winners and determines if that contestant was one of the winners from the previous round.
	 * @param checkedCont a contestant who might be a winner.
	 * @return whether that contestant is a winner.
	 */
	public boolean isWinner(IContestant checkedCont) {
		
		for (IContestant cont : this.prevWinners) {
			if (cont.equals(checkedCont)) {
				return true;
			}
		} return false;
	}

}
