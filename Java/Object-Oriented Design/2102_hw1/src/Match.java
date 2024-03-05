
public class Match {

	IContestant team1;
	IContestant team2;
	IResult results;
	
	Match (IContestant team1, IContestant team2, IResult results) {
		this.team1 = team1;
		this.team2 = team2;
		this.results = results;
	}
	
	IContestant winner() {
		if (results.isValid()) {
			return results.getWinner();
		} else {
			return null;
		}
	}
	
}
