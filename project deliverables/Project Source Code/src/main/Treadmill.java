package main;
	
	public class Treadmill extends Item {
		public int fitnessBoost = 5;
		public static int price;
		/**
		 * Creates an instance of Treadmill.
		 */
		public Treadmill() {
			super("Treadmill", "Adds 5 to an athletes fitness stat.", 50000, 25000);
		}
		/**
		 * returns the price of the item
		 * @return the price
		 */
		public static int getPrice() {
			return 100000;
		}
		/**
		 * allows an athlete to consume the item
		 */
		public void consume(Athlete athlete) {
			athlete.setFitness(athlete.getFitness() + fitnessBoost);
		}
	}
