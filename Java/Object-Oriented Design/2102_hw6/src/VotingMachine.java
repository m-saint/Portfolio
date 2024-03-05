/**
 * user interface simulating a voting booth
 */
import java.util.LinkedList;
import java.util.Scanner;

public class VotingMachine {
	
	private ElectionData ED;
	private LinkedList<String> ballot;
	private Scanner keyboard = new Scanner(System.in);
	
	public VotingMachine () {
		this.ED = new ElectionData();
		this.ballot = new LinkedList<String>();
	}

/**
 * prints the ballot
 */
	public void printBallot() {
	    System.out.println("The candidates are ");
	    for (String s : ballot) {
	      System.out.println(s);
	    }
	  }
	
/**
 * allows the user to add a write-in candidate	
 * @param candidate the candidate to be written-in
 */
	public void addWriteIn(String candidate) {
		try {
			this.ED.addCandidate(candidate);
		} catch (CandidateExistsException e) {
			System.out.println(e.getCandidate() + " is already on the ballot");
		}
	}
	
	  /**
	   * deals with input/output
	   */
	  public void screen() {
	    this.printBallot();
	    System.out.print("first choice?");
	    String first = keyboard.next();
	    System.out.println("second choice?");
	    String second = keyboard.next();
	    System.out.println("third choice?");
	    String third = keyboard.next();
	    
	    try {this.ED.processVote(first, second, third);}
	    
	    catch (UnknownCandidateException u) {
	    	System.out.println("would you like to add " + u.getCandidate() + " to the ballot?");
	    	if (keyboard.next().toUpperCase().equals("Y")) {
	    		addWriteIn(u.getCandidate());
	    		System.out.println(u.getCandidate() + " was added successfully");
	    	}
	    }
	    
	    catch (DuplicateVotesException d) {
	    	System.out.println("you cannot vote for " + d.getCandidate() + " twice");
	    	screen();
	    }
	    
	    System.out.println("You voted for " + first + ", then " + second + ", then " + third);
	  }

}
