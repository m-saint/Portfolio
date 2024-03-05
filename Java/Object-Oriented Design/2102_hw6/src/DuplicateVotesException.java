
public class DuplicateVotesException extends Exception{
	
	private String candidate;
	
	public DuplicateVotesException(String candidate) {
		this.candidate = candidate;
	}
	
	public String getCandidate() {
		return this.candidate;
	}

}
