/**
 * provides data structure to record 1st/2nd/3rd-place votes
 */
import java.util.LinkedList;

public class Votes {
	
	private LinkedList<String> firstVotes;
	private LinkedList<String> secondVotes;
	private LinkedList<String> thirdVotes;
	
	public Votes () {
		this.firstVotes  = new LinkedList<String>();
		this.secondVotes  = new LinkedList<String>();
		this.thirdVotes  = new LinkedList<String>();
	}
	
	/**
	 * adds a vote to the appropriately ranked list 
	 * @param rank the rank of the vote (first, second, third)
	 * @param choice the name of the candidate being voted for
	 */
	public void add(String rank, String choice) {
		if (rank.equals("first")) {
			this.firstVotes.add(choice);
		}
		else if (rank.equals("second")) {
			this.secondVotes.add(choice);
		}
		else if (rank.equals("third")) {
			this.thirdVotes.add(choice);
		}
	}
	
	/**
	 * gets the size of the appropriately ranked list
	 * @param rank the rank of the desired list (first, second, third)
	 * @return the desired size 
	 */
	public int getSize(String rank) {
		if (rank.equals("first")) {
			return this.firstVotes.size();
		}
		else if (rank.equals("second")) {
			return this.secondVotes.size();
		}
		else if (rank.equals("third")) {
			return this.thirdVotes.size();
		}
		
		else return -1;
	}

}
