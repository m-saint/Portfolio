
public class CandidateExistsException extends Exception {

	private String candidate;
	
	public CandidateExistsException(String candidate) {
		this.candidate = candidate;
	}

	public String getCandidate() {
		return candidate;
	}
	
	
	
}
