package test;
import main.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeamTest {
	private Team team;
	private Athlete athlete1;
	private Athlete athlete2;
	@BeforeEach
	void setUp() {
		team = new Team("Test");
		athlete1 = new Athlete("Athlete 1");
		athlete2 = new Athlete("Athlete 2");
	}
	
	@Test
	void testAddPlayer() {
		team.addPlayer(athlete1);
		Assertions.assertEquals(1, team.getNumPlayers());
		
		team.addPlayer(athlete2);
		Assertions.assertEquals(2, team.getNumPlayers());
		
        ArrayList<Athlete> players = team.getPlayers();
        Assertions.assertTrue(players.contains(athlete1));
        Assertions.assertTrue(players.contains(athlete2));
	}
	
	@Test
	void testRemovePlayer() {
		team.addPlayer(athlete1);
		team.addPlayer(athlete2);
		
		team.removePlayer(athlete1);
		Assertions.assertEquals(1, team.getNumPlayers());
        Assertions.assertFalse(team.getPlayers().contains(athlete1));
        Assertions.assertTrue(team.getPlayers().contains(athlete2));
	}
	
    @Test
    void testAddToStartingLineup() {
        Assertions.assertTrue(team.addToStartingLineup(athlete1));
        Assertions.assertEquals(1, team.getStarters().size());
        Assertions.assertTrue(team.getStarters().contains(athlete1));
        
        Assertions.assertTrue(team.addToStartingLineup(athlete2));
        Assertions.assertEquals(2, team.getStarters().size());
        Assertions.assertTrue(team.getStarters().contains(athlete2));
    }
    

    
    @Test
    void testGetTeamRating() {
        team.addPlayer(athlete1);
        team.addPlayer(athlete2);
        
        assertEquals((int) ((athlete1.getOverall() + athlete2.getOverall()) / 2), Team.getTeamRating());
    }
    
    @Test
    void testGetStartersRating() {
    	team.addToStartingLineup(athlete1);
    	team.addToStartingLineup(athlete2);
    	Assertions.assertEquals((int) ((athlete1.getOverall() + athlete2.getOverall())/2), team.getStartersRating());
    }
    
    @Test
    void testGetStartersStamina() {
    	team.addToStartingLineup(athlete1);
    	team.addToStartingLineup(athlete2);
    	Assertions.assertEquals((int) ((athlete1.getStamina() + athlete2.getStamina())/2), team.getStartersStamina());
    }
    
    @Test
    void testClearTeam() {
    	team.addPlayer(athlete1);
    	team.addPlayer(athlete2);
    	ArrayList<Item> items = new ArrayList<Item>();
    	Team.setInventory(items);
    	Team.clearTeam();
    	Assertions.assertEquals(0, team.getNumPlayers());
    }
}
