package main;

/**
 * Represents the User in the game
 *
 */
public class Player {
	private String playerName;
	private int points;
	private static int week;
	
	
	/**
	 * Instantiates the Player
	 * @param playerName the player's name
	 */
	public Player(String playerName) {
		this.playerName = playerName;
		this.points = 0;
		this.week = 0;
	}
	
	/**
	 * Gets the player name
	 * @return name
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Gets the current week
	 * @return week
	 */
	public static int getWeek() {
		return week;
	}
	
	/**
	 * Goes to the next week
	 */
	public static void incrementWeek() {
		week += 1;
	}
	
	/**
	 * Sets the player name
	 * @param playerName name
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * gets the player's points
	 * @return points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Sets the player's points
	 * @param points points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * Adds points to the current points
	 * @param amount amount to add
	 */
	public void addPoints(int amount) {
		points += amount;
	}	
}
