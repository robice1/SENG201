package main;
/**
 * Represents the energy drink item
 *
 */
public class EnergyDrink extends Item {
	public int staminaBoost = 20;
	/**
	 * Instantiates the energy drink item
	 */
	public EnergyDrink() {
		super("Energy Drink", "Adds 20 to a players stamina stat.", 20000, 10000);
	}
	/**
	 * Returns the price of the item
	 * @return the price
	 */
	public static int getPrice() {
		return 20000;
	}
	/**
	 * Consumes the item on an athlete
	 */
	public void consume(Athlete athlete) {
		athlete.setStamina(athlete.getStamina() + staminaBoost);
	}
}
