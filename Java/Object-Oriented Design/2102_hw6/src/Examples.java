/**
 * holds test cases
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {
	
	public ElectionData setup() {
		ElectionData ED = new ElectionData();
		try {
			ED.addCandidate("red");
			ED.addCandidate("yellow");
			ED.addCandidate("blue");
		}
		
		catch(Exception e) {}
		
		try {
			ED.processVote("red", "yellow", "blue");
			ED.processVote("red", "blue", "yellow");
			ED.processVote("yellow", "red", "blue");
		}
		
		catch (Exception e) {}
		
		return ED;
	}
	
	public ElectionData setupTie() {
		ElectionData ED = new ElectionData();
		try {
			ED.addCandidate("r");
			ED.addCandidate("y");
			ED.addCandidate("b");
		}
		
		catch(Exception e) {}
		
		try {
			ED.processVote("r", "y", "b");
			ED.processVote("b", "r", "y");
			ED.processVote("y", "b", "r");
		}
		
		catch (Exception e) {}
		
		return ED;
	}
	
	@Test
	public void testMostFirsts() {
		assertEquals("red", setup().findWinnerMostFirstVotes());
	}
	
	@Test
	public void testMostFirstsTie() {
		assertEquals("Runoff required", setupTie().findWinnerMostFirstVotes());
	}
	
	@Test
	public void testMostPoints() {
		assertEquals("red", setup().findWinnerMostPoints());
	}
	
	@Test
	public void testMostPointsTie() { 
		assertEquals("y", setupTie().findWinnerMostPoints());
	}
	
	@Test(expected=UnknownCandidateException.class)
	public void testUnknownEx() throws UnknownCandidateException, DuplicateVotesException {
		try {
			setup().processVote("red", "green", "blue");
		}
		
		catch(DuplicateVotesException d) {
			fail();
		}
	}
	
	@Test(expected=CandidateExistsException.class)
	public void testExistsEx() throws CandidateExistsException {
		setup().addCandidate("yellow");
	}
	
	@Test(expected=DuplicateVotesException.class)
	public void testDupEx() throws DuplicateVotesException, UnknownCandidateException{
		try {
			setup().processVote("red", "red", "red");
		}
		
		catch(UnknownCandidateException u) {
			fail();
		}
	}
}
