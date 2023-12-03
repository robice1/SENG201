package main;
/**
 * Represents the Dumbbell Item
 *
 */
public class Dumbbells extends Item {
	public int defenseBoost = 5;
	/**
	 * Instantiates the dumbbell item
	 */
	public Dumbbells() {
		super("Dumbbell", "Adds 5 to an athletes defensive stat.", 50000, 25000);
	}
	/**
	 * Returns the price of the item
	 * @return the price
	 */
	public static int getPrice() {
		return 50000;
	}
	/**
	 * Consumes the item
	 */
	public void consume(Athlete athlete) {
		athlete.setDefense(athlete.getDefense() + 5);
	}
}
