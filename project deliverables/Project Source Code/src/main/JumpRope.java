package main;

/**
 * Represents the Jump Rope item
 *
 */
public class JumpRope extends Item {
	public int offenseBoost = 5;
	public static int price;
	
	/**
	 * Instantiates the Jump Rope item
	 */
	public JumpRope() {
		super("Jump Rope", "Adds 5 to an athletes offensive stat.", 50000, 25000);
	}
	/**
	 * Returns the price of the item
	 * @return the price
	 */
	public static int getPrice() {
		return 100000;
	}
	/**
	 * Consumes the item onto an athlete
	 */
	public void consume(Athlete athlete) {
		athlete.setOffense(athlete.getOffense() + offenseBoost);
	}
}
