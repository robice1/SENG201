package main;


/**
 * Represents an Opponent team in the game
 *
 */
public class OpponentTeam {
	
	private String name;
	private int rating;
	
	/**
	 * Instantiates the opponent team
	 * @param name team name
	 * @param rating team rating
	 */
	public OpponentTeam(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}
	
	/**
	 * returns the name of the opponent team
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the opponent team
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * gets the rating of the opponent team
	 * @return rating
	 */
	public int getRating() {
		return rating;
	}
	
	/**
	 * sets the rating of the opponent team
	 * @param rating the new rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
