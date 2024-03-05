
public class UnknownCandidateException extends Exception {

	
	private String candidate;
	
	public UnknownCandidateException(String candidate) {
		this.candidate = candidate;
	}
	
	public String getCandidate() {
		return this.candidate;
	}

}

