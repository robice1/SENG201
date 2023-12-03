package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.*;

import java.util.ArrayList;

class AthleteTest {

	@Test
	public void testSetName() {
		Athlete athlete = new Athlete("Old name");
		String newName = "New name";
		athlete.setName(newName);
		Assertions.assertEquals(newName, athlete.getName());
	}
	@Test
	public void testChangeStats() {
		Athlete athlete = new Athlete("Test");
		int initialOffense = athlete.getOffense();
		int initialDefense = athlete.getDefense();
		
		athlete.setOffense(athlete.getOffense() + 10);
		athlete.setDefense(athlete.getDefense() + 10);
		
		Assertions.assertEquals(initialOffense + 10, athlete.getOffense());
		Assertions.assertEquals(initialDefense + 10, athlete.getDefense());
	}
	
	@Test
	public void testInjured() {
		Athlete athlete = new Athlete("Test");
		athlete.setStamina(0);
		athlete.updateInjured();
		
		Assertions.assertTrue(athlete.getInjured());
	}
	@Test
	public void testTeamSetup() {

	}
}
