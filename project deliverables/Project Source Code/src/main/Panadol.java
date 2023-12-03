package main;

/**
 * Represents the panadol item in the game
 *
 */
public class Panadol extends Item {
	private static int price;
	
	/**
	 * Instantiates the panadol item
	 */
	public Panadol() {
		super("Panadol", "Makes an injured athlete healthy again.", 100000, 50000);
	}
	
	/**
	 * Gets the price of the item
	 * @return price
	 */
	public static int getPrice() {
		return 100000;
	}
	
	/**
	 * Consumes the item on to an Athlete
	 */
	public void consume(Athlete athlete) {
		athlete.setInjured(false);
	}
}
