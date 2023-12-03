package test;

import main.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatchupTest {
	private Matchup matchup;
	private Team playerTeam;
	private OpponentTeam opponentTeam;
	
	
	@BeforeEach
	public void setUp() {
		playerTeam = new Team("Player team");
		opponentTeam = new OpponentTeam("Opponent", 0);
		matchup = new Matchup(playerTeam, opponentTeam);
	}
	
	@Test
	void testOppRating() {
		int teamRating = Team.getTeamRating();
		matchup.setDifficulty(0);
		Matchup.setOpponentRating();
		Assertions.assertEquals(teamRating, opponentTeam.getRating());
		
	}
	
	@Test
	void testHalfActions() {
		Matchup.setHalf(1);
		Assertions.assertEquals(1, Matchup.getHalf());
		Matchup.nextHalf();
		Assertions.assertEquals(2, Matchup.getHalf());
	}
	
	@Test
	void testSetPlayerScore() {
		int score = Matchup.playerHalfScore();
		Matchup.setPlayerScore(20);
		Assertions.assertEquals(score + 20, matchup.getPlayerScore());
	}
}
