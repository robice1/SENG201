/**
 * This class implements an Alien that rids on comets through the galaxy
 * These aliens are hardy and dangerous, since they look so ugly you
 * will melt upon seeing them.
 *
 * @author Matthew Ruffell
 * @version 1.1, Feb 2018.
 */
public class CometAlien {

	/**
	 * The name of the Alien
	 */
	public String name;
	/**
	 * The age of the Alien
	 */
	public int age;
	/**
	 * The height of the Alien
	 */
	public int height;
	/**
	 * The home place of the Alien
	 */
	public String homeGalaxy;

	/**
	 * Makes the Alien take grip onto the Comet.
	 * Once the Alien holds on, it will never let go
	 */
	public void holdOntoComet() {
		// implementation
	}

	/**
	 * The Alien will eat Comet dust to survive. Makes the Alien happy.
	 *
	 * @param comet		The comet to eat dust from
	 */
	public void eatCometDust(String comet) {
		// implementation
	}

	/**
	 * Returns the Galaxy the comet being ridden is traveling to.
	 *
	 * @param comet		The comet being ridden.
	 * @return 			The galaxy where the comet is going.
	 */
	public String getDestination(String comet) {
		// implementation
	}

}
