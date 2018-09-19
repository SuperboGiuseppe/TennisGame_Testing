import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();
	}
	
	@Test
	public void testTennisGame_Player1WinsGameAfterDeuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		//Assert
		assertEquals("player1 wins",game.getScore());
	}
	
	//Discovered a bug with this test
	@Test
	public void testTennisGame_Player2AdvantageAfterDeuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("player2 has advantage",game.getScore());
	}
	
	@Test
	public void testTennisGame_Player2WinsGameAfterDeuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("player2 wins",game.getScore());
	}
	
	@Test
	public void testTennisGame_0_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		//Act
		//Assert
		assertEquals("love - 15", game.getScore());
	}
	
	@Test
	public void testTennisGame_15_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("15 - 15", game.getScore());
	}
	
	@Test
	public void testTennisGame_15_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("15 - 30", game.getScore());
	}
	
	@Test
	public void testTennisGame_30_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("30 - 30", game.getScore());
	}
	
	@Test
	public void testTennisGame_30_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("30 - 40", game.getScore());
	}
	
	@Test
	public void testTennisGame_15_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		//Act
		//Assert
		assertEquals("15 - love", game.getScore());
	}
	
	@Test
	public void testTennisGame_30_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("30 - love", game.getScore());
	}
	
	@Test
	public void testTennisGame_40_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("40 - love", game.getScore());
	}
	
	@Test
	public void testTennisGame_0_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		//Act
		//Assert
		assertEquals("love - 30", game.getScore());
	}
	
	@Test
	public void testTennisGame_0_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		//Assert
		assertEquals("love - 40", game.getScore());
	}

	
	//This test discovered a bug
	@Test
	public void testTennisGame_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		//Assert
		assertEquals("deuce", game.getScore());
	}
	
	@Test
	public void testTennisGame_40_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		//Assert
		assertEquals("40 - 30", game.getScore());
	}
	
	@Test
	public void testTennisGame_40_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("40 - 15", game.getScore());
	}
	
	@Test
	public void testTennisGame_15_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		//Assert
		assertEquals("15 - 40", game.getScore());
	}
}

