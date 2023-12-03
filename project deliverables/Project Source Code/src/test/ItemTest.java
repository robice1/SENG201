package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import main.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void testConsume() {
		Athlete athlete = new Athlete("Test");
		int offense = athlete.getOffense();
		int defense = athlete.getDefense();
		int fitness = athlete.getFitness();
		athlete.setStamina(athlete.getStamina() - 20);
		athlete.setInjured(true);
		Panadol test1 = new Panadol();
		test1.consume(athlete);
		JumpRope test2 = new JumpRope();
		test2.consume(athlete);
		EnergyDrink test3 = new EnergyDrink();
		test3.consume(athlete);
		Dumbbells test4 = new Dumbbells();
		test4.consume(athlete);
		Treadmill test5 = new Treadmill();
		test5.consume(athlete);
		
		
		Assertions.assertFalse(athlete.getInjured());
		Assertions.assertEquals(offense + 5, athlete.getOffense());
		Assertions.assertEquals(defense + 5, athlete.getDefense());
		Assertions.assertEquals(fitness + 5, athlete.getFitness());
		Assertions.assertEquals(100, athlete.getStamina());
	}
	
	@Test
	public void testGetters() {
		Panadol panadol = new Panadol();
		
		Assertions.assertEquals("Panadol", panadol.getItemType());
		Assertions.assertEquals("Makes an injured athlete healthy again.", panadol.getDescription());
		
	}
}
