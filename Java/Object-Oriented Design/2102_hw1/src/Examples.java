//Myles St. Jean && Ezra Yohay

import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
    
    SoccerTeam A = new SoccerTeam("USA", "Blue", true, 0, 0);
	SoccerTeam B = new SoccerTeam("USA", "Red", false, 0, 0);
	SoccerTeam C = new SoccerTeam("USA", "White", true, 1, 0);
	SoccerTeam D = new SoccerTeam("USA", "Green", false, 0, 0);
	
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
	
	Match AvB = new Match(A, B, Uno);
	Match CvD = new Match(C, D, altDos);
	Match AlphaBeta = new Match(Alpha, Beta, Tres);
	Match GammaDelta = new Match(Gamma, Delta, varCuatro);
	
	@Test
	public void isValidTestSoc() {
		assertEquals(true, Uno.isValid());
	}
	
	@Test
	public void isValidTestLego() {
		assertEquals(true, Tres.isValid());
	}
	
	@Test
	public void notValidTestSoc1() {
		assertEquals(false, altUno.isValid());
	}
	
	@Test
	public void notValidTestSoc2() {
		assertEquals(false, altDos.isValid());
	}
	
	@Test
	public void notValidTestLego1() {
		assertEquals(false, altTres.isValid());
	}
	
	@Test
	public void notValidTestLego2() {
		assertEquals(false, varTres.isValid());
	}
	
	@Test
	public void notValidTestLego3() {
		assertEquals(false, altCuatro.isValid());
	}
	
	@Test
	public void notValidTestLego4() {
		assertEquals(false, varCuatro.isValid());
	}
	
	@Test
	public void getScoreTestNoFall() {
		assertEquals(7.5, Tres.getScore(2.5, 5, false), 0);
	}
	
	@Test
	public void getScoreTestFall() {
		assertEquals(5.5, Cuatro.getScore(4.5, 6, true), 0 );
	}
	
	@Test
	public void getWinnerTestSoc() {
		assertEquals(Dos.team1, Dos.getWinner());
	}
	
	@Test
	public void getWinnerTestLego() {
		assertEquals(Cuatro.team2, Cuatro.getWinner());
	}
	
	@Test
	public void winnerTestSocValid() {
		assertEquals(AvB.team2, AvB.winner());
	}
	
	@Test
	public void winnerTestSocInvalid() {
		assertEquals(null, CvD.winner());
	}
	
	
	@Test
	public void winnerTestLegoValid() {
		assertEquals(AlphaBeta.team1, AlphaBeta.winner());
	}
	
	@Test
	public void winnerTestLegoInvalid() {
		assertEquals(null, GammaDelta.winner());
	}
	
	@Test
	public void expectTestSocRitualTrue() {
		assertEquals(true, A.expectToBeat(B));
	}
	

	@Test
	public void expectTestSocRitualFalse() {
		assertEquals(false, B.expectToBeat(A));
	}
	

	@Test
	public void expectTestSocTrue() {
		assertEquals(true, C.expectToBeat(A));
	}
	

	@Test
	public void expectTestSocFalse() {
		assertEquals(false, A.expectToBeat(C));
	}
	

	@Test
	public void expectTestSocUnclear() {
		assertEquals(false, B.expectToBeat(D));
	}
	

	@Test
	public void expectTestLegoTrue() {
		assertEquals(true, Delta.expectToBeat(Alpha));
	}
	

	@Test
	public void expectToBeatTestLegoFalse() {
		assertEquals(false, Beta.expectToBeat(Gamma));
	}
	

	@Test
	public void expectToBeatTestLegoUnclear() {
		assertEquals(false, Alpha.expectToBeat(Beta));
	}
	
}