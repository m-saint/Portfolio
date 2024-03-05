
public class LegoRobotTeam implements IContestant {
	
	String school;
	String feature;
	double prevscore;
	
	LegoRobotTeam (String school, String feature, double prevscore) {
		this.school = school;
		this.feature = feature;
		this.prevscore = prevscore;
	}
	
	boolean expectToBeat (LegoRobotTeam opponent) {
		if (this.prevscore > opponent.prevscore) {
			return true;
		} else if (this.prevscore < opponent.prevscore) {
			return false;
		} else return false;
	}

}
