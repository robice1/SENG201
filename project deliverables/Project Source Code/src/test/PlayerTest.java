package test;
import main.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	private Player player;
	
	@BeforeEach
	void setUp() {
		player = new Player("Test");
	}

	@Test
	void testIncrementWeek() {
		int week = Player.getWeek();
		Player.incrementWeek();
		
		Assertions.assertEquals(week + 1, Player.getWeek());
	}
	
	@Test
	void testAddPoints() {
		int initialPoints = player.getPoints();
		int amount = 100;
		player.addPoints(amount);
		
		Assertions.assertEquals(initialPoints + amount, player.getPoints());
	}
}
