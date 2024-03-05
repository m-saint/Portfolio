//Myles St. Jean && Ezra Yohay

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.LinkedList;

public class Examples {
    
    SoccerTeam A = new SoccerTeam("USA", "Blue", true, 0, 0);
	SoccerTeam B = new SoccerTeam("USA", "Red", false, 0, 0);
	SoccerTeam C = new SoccerTeam("USA", "White", true, 1, 0);
	SoccerTeam D = new SoccerTeam("USA", "Green", false, 0, 0);
	
	SoccerTeam E;
	
	String meatball = E.country;
	
	LegoRobotTeam Alpha = new LegoRobotTeam("WPI", "Fire", 0);
	LegoRobotTeam Beta = new LegoRobotTeam("WPI", "Saw", 0);
	LegoRobotTeam Gamma = new LegoRobotTeam("WPI", "Hammer", 2);
	LegoRobotTeam Delta = new LegoRobotTeam("WPI", "Flipper", 2);
	
	SoccerResult Uno = new SoccerResult(A, B, 10, 15);
	SoccerResult altUno = new SoccerResult(A, B, 150, 0);
	SoccerResult Dos = new SoccerResult(C, D, 20, 5);
	SoccerResult altDos = new SoccerResult(C, D, 300, 200);
	
	LegoRobotResult Tres = new LegoRobotResult(Alpha, Beta, 2.5, 5, false, 3.25, 4, true);
	LegoRobotResult altTres = new LegoRobotResult(Alpha, Beta, 2.5, 8, false, 3.25, 8, true);
	LegoRobotResult varTres = new LegoRobotResult(Alpha, Beta, 17, 5, false, 18, 4, true);
	LegoRobotResult Cuatro = new LegoRobotResult(Gamma, Delta, 1.75, 3, true, 4.5, 6, true);
	LegoRobotResult altCuatro = new LegoRobotResult(Gamma, Delta, 1.75, 8, true, 4.5, 6, true);
	LegoRobotResult varCuatro = new LegoRobotResult(Gamma, Delta, 19, 3, true, 16, 6, true);
	
	Match AvB = new Match(A, B, Uno); // B wins
	Match CvD = new Match(C, D, Dos); // C wins
	Match AlphaBeta = new Match(Alpha, Beta, Tres); // Alpha wins
	Match GammaDelta = new Match(Gamma, Delta, varCuatro); // null winner
	
	LinkedList<Match> socList = new LinkedList<Match>();
	LinkedList<Match> legoList = new LinkedList<Match>();
	
	LinkedList<IContestant> prevSocWinners = new LinkedList<IContestant>();
	LinkedList<IContestant> prevLegoWinners = new LinkedList<IContestant>();
	
	LinkedList<IWinner> socRoundList = new LinkedList<IWinner>();
	LinkedList<IWinner> legoRoundList = new LinkedList<IWinner>();
	
	InitialRound iSocRound = new InitialRound(socList);
	InitialRound iLegoRound = new InitialRound(legoList);
	
	AdvancedRound advSocRound = new AdvancedRound(socList, prevSocWinners);
	AdvancedRound advLegoRound = new AdvancedRound(legoList, prevLegoWinners);
	
	Tournament socTour = new Tournament(socRoundList);
	Tournament legoTour = new Tournament(legoRoundList);
	
	@Before
	public void listSetup() {
	socList.add(AvB);
	socList.add(CvD);
	legoList.add(AlphaBeta);
	legoList.add(GammaDelta);
	prevSocWinners.add(B);
	prevSocWinners.add(A);
	prevLegoWinners.add(Alpha);
	prevLegoWinners.add(Delta);
	socRoundList.add(iSocRound);
	socRoundList.add(advSocRound);
	legoRoundList.add(iLegoRound);
	legoRoundList.add(advLegoRound);
	}

	public boolean sameList() { 
		LinkedList<IContestant> generatedLoW = advSocRound.getMatchWinners();
		LinkedList<IContestant> expectedLoW = new LinkedList<IContestant>();
		expectedLoW.add(B);
		expectedLoW.add(C);
		for (int k = 0; k < generatedLoW.size(); k++) {
			if(!expectedLoW.get(k).equals(generatedLoW.get(k))) {
				return false;
			}
		} return true;
	}
	
	@Test
	public void matchWinnersTest() {
		
		assertEquals(true, sameList());
	}
	
	@Test
	public void numWinnersTest() {
		assertEquals(2, iSocRound.getNumWinners());
	}
	
	@Test
	public void numWinnersTest_wNull() {
		assertEquals(1, advLegoRound.getNumWinners());
	}
	
	@Test
	public void iTrueIsWinnerTest() {
		assertEquals(true, iSocRound.isWinner(B));
	}
	
	@Test
	public void iFalseIsWinnerTest() {
		assertEquals(false, iLegoRound.isWinner(Delta));
	}
	
	@Test
	public void advTrueIsWinnerTest() {
		assertEquals(true, advLegoRound.isWinner(Alpha));
	}
	
	@Test
	public void advFalseIsWinnerTest() {
		assertEquals(false, advSocRound.isWinner(D));
	}
	
	@Test
	public void validFinalWinnerTest() {
		assertEquals(true, socTour.finalWinnerIsValid(B));
	}
	
	@Test
	public void invalidFinalWinnerTest() {
		assertEquals(false, legoTour.finalWinnerIsValid(Beta));
	}
	
	
	
	
}