/**
 * deals with ballot and votes information
 */
import java.util.HashMap;
class ElectionData {
  private HashMap<String, Votes> voteSystem;
  private int numVotes;
  
  public ElectionData() {
	  this.voteSystem = new HashMap<String,Votes>();
	  this.numVotes = 0;
  }
  /**
   * gets a list of names of candidates on the ballot for an election
   * @return said list
   */
  
  
  /**
   * stores a single voter's choices in the voting system. 
   * @param choice1 the voter's first choice
   * @param choice2 the voter's second choice
   * @param choice3 the voter's third choice
   * @throws DuplicateVotesException when voter votes for candidate multiple times
   * @throws UnknownCandidateException when when voter votes for candidate not on the ballot
   */
  public void processVote(String choice1, String choice2, String choice3) throws DuplicateVotesException, UnknownCandidateException {
	  
	  if (!this.voteSystem.containsKey(choice1)) {
		  throw new UnknownCandidateException(choice1);
	  }
	  
	  if (!this.voteSystem.containsKey(choice2)) {
		  throw new UnknownCandidateException(choice2);
	  }
	  
	  if (!this.voteSystem.containsKey(choice3)) {
		  throw new UnknownCandidateException(choice3);
	  }
	  
	  else if (choice1.equals(choice2) || choice1.equals(choice3)) {
		  throw new DuplicateVotesException(choice1);
	  }
	  else if (choice2.equals(choice3)) {
		  throw new DuplicateVotesException(choice2);
	  }
	  else {
	  this.voteSystem.get(choice1).add("first", choice1);
	  this.voteSystem.get(choice2).add("second", choice2);
	  this.voteSystem.get(choice3).add("third", choice3);
	  numVotes++;
	  }
  }
  
  /**
   * adds the candidate to the ballot
   * @param newCandidate the candidate to be added
   * @throws CandidateExistsException when the candidate is already on the ballot
   */
  public void addCandidate(String newCandidate) throws CandidateExistsException {
	  if (this.voteSystem.containsKey(newCandidate)) {
		  throw new CandidateExistsException(newCandidate);
	  }
	  else {
		  this.voteSystem.put(newCandidate, new Votes());
	  }
  }

  /**
 * determines the winner as the candidate with more than 50% of first place votes.
 * @return the name of the winning candidate, or indicates otherwise
 */
  public String findWinnerMostFirstVotes() {
	  for (String candidate : this.voteSystem.keySet()) {
		  if (this.voteSystem.get(candidate).getSize("first") > numVotes/2) {
			  return candidate;
		  }
	  } return "Runoff required";
  }
  
  /**
   * determines the winner as the candidate with the most points under the following formula: three points for each first-place vote they received, two points for each second-place vote they received, and one point for each third-place vote they received.
   * @return the name of the winning candidate
   */
public String findWinnerMostPoints() {
	
	String currentWinner = "";
	int currentMax = -1;
	
	for (String candidate : this.voteSystem.keySet()) {
		
		int numPoints = 0;
		numPoints += (this.voteSystem.get(candidate).getSize("first") * 3);
		numPoints += (this.voteSystem.get(candidate).getSize("second") * 2);
		numPoints += this.voteSystem.get(candidate).getSize("third");
		
		if (numPoints >= currentMax) {
			currentMax = numPoints;
			currentWinner = candidate;
		}
	}
	  return currentWinner;
  }
  
  
  }
