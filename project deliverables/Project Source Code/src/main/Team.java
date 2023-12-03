package main;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a Team in the game.
 */
public class Team {
	private String name;
	private static ArrayList<Athlete> players;
	public static ArrayList<Athlete> startingFive;
	public static ArrayList<Athlete> reserveFive;
	private static ArrayList<Item> inventory;
	public int teamRating;
	public static Team playerTeam;
	public static int remPicks;
	public static ArrayList<Athlete> benchFive;
	public static ArrayList<Athlete> injuredPlayers;
	public static int week;
	public static int points;
	public static int wins;
	public static ArrayList<Athlete> allPlayers;
	
	/**
	 * Constructs a new team.
	 * 
	 * @param name the name of the team
	 */
	public Team(String name) {
		this.name = name;
		playerTeam = this;
		players = new ArrayList<Athlete>();
		startingFive = new ArrayList<Athlete>();
		benchFive = new ArrayList<Athlete>();
		injuredPlayers = new ArrayList<Athlete>();
		allPlayers = new ArrayList<Athlete>();
	}
	/**
	 * Returns the Array list of players
	 * 
	 * @return the list of players
	 */
	public static ArrayList<Athlete> getAllPlayers() {
		return allPlayers;
	}
	
	/**
	 * Returns the total points.
	 * 
	 * @return the points
	 */
	public static int getPoints() {
		return points;
	}
	
	/**
	 * Adds the points earned to the total points
	 * 
	 * @param ptsToBeAdded the points to be added
	 */
	public static void addPoints(int ptsToBeAdded) {
		points += ptsToBeAdded;
	}
	/**
	 * Returns the total inventory of items
	 * 
	 * @return the list of items (inventory)
	 */
	public static ArrayList<Item> getInventory() {
		return inventory;
	}
	
	/**
	 * Replaces the inventory with a new one
	 * 
	 * @param newInv the new inventory
	 */
	public static void setInventory(ArrayList<Item> newInv) {
		inventory = newInv;
	}
	/**
	 * Returns the current week
	 * 
	 * @return the current week
	 */
	public static int getWeek() {
		return week;
	}
	/**
	 * Moves to the next week
	 */
	public static void incrementWeek() {
		week++;
	}
	/**
	 * returns the no. of wins
	 * 
	 * @return wins
	 */
	public static int getWins() {
		return wins;
	}
	/**
	 * Adds a win
	 */
	public static void incrementWins() {
		wins ++;
	}
	/**
	 * Returns the name of the team
	 * 
	 * @return the team name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the remaining picks in the draft.
	 * 
	 * @return the remaining picks
	 */
	public static int getPicks() {
		return remPicks;
	}
	
	/**
	 * Replaces the amount of remaining picks
	 * 
	 * @param newPicks the new number of picks
	 */
	public static void setPicks(int newPicks) {
		remPicks = newPicks;
	}
	/**
	 * Sets a new name
	 * 
	 * @param newName the new name
	 */
	public void setName(String newName) {
		name = newName;
	}
	/**
	 * Get the number of players in the squad
	 * 
	 * @return the number of players
	 */
	public int getNumPlayers() {
		return players.size();
	}
	/**
	 * Returns the list of starting players
	 * 
	 * @return the starting five
	 */
	public ArrayList<Athlete> getStarters() {
		return startingFive;
	}
	/**
	 * Set the new starting five
	 * 
	 * @param theStarters the new starting five
	 */
	public void setStarters(ArrayList<Athlete> theStarters) {
		startingFive = theStarters;
	}
	
	/**
	 * Get the bench players
	 * 
	 * @return the bench
	 */
	public ArrayList<Athlete> getBench() {
		return benchFive;
	}
	
	/**
	 * Set the new bench
	 * 
	 * @param theBench the new bench
	 */
	public void setBench(ArrayList<Athlete> theBench) {
		benchFive = theBench;
	}
	
	/**
	 * Returns the player list
	 * 
	 * @return the players
	 */
	public ArrayList<Athlete> getPlayers() {
		return players;
	}
	/**
	 * Adds an athlete to the team
	 * 
	 * @param player the new athlete
	 */
	
	public void addPlayer(Athlete player) {	
		allPlayers.add(player);
		players.add(player);
	}
	
	/**
	 * Removes a player from the team
	 * 
	 * @param player the player to remove
	 */
	public void removePlayer(Athlete player) {
			allPlayers.remove(player);
			players.remove(player);
	}
	
	/**
	 * Adds a player to the starting five
	 * @param player the player to add
	 * @return true if added, false if not.
	 */
	public boolean addToStartingLineup(Athlete player) {
		if (startingFive.size() < 5) {
			startingFive.add(player);
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Adds an athlete to reserves
	 * @param player the player to add
	 * @return true if added, false if not
	 */
	public boolean addToReserveLineup(Athlete player) {
		if (reserveFive.size() < 5) {
			reserveFive.add(player);
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Removes a player from the starting five
	 * @param player the player to remove
	 * @return true if removed, false if not
	 */
	public boolean removeFromStartingLineup(Athlete player) {
		if (startingFive.contains(player)) {
			startingFive.remove(player);
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Sets the players array list
	 * @param athletes the new team
	 */
	public void setUpTeam(ArrayList<Athlete> athletes) {
		players = athletes;
	}
	/**
	 * Returns the average rating of the team
	 * @return the team rating
	 */
	public static int getTeamRating() {
		if (players.size() != 0) {
			int totalRating = 0;
			for (Athlete player : players) {
				totalRating += player.getOverall();
			}
			int teamRating = (int) (totalRating / players.size());
			return teamRating;
		}
		return 0;
		
	}
	/**
	 * Gets the rating of the starters
	 * 
	 * @return the average starter rating
	 */
	public int getStartersRating() {
		int totalRating = 0;
		for (Athlete player : startingFive) {
			totalRating += player.getOverall();
		}
		int startersRating = (int) (totalRating / startingFive.size());
		return startersRating;
	}
	
	/**
	 * Gets the average stamina of the starters
	 * @return the average stamina
	 */
	public int getStartersStamina() {
		int totalStamina = 0;
		for (Athlete player : startingFive) {
			totalStamina += player.getStamina();
		}
		int startersStamina = (int) (totalStamina / startingFive.size());
		return startersStamina;
	}
	
	/**
	 * Removes all values from the team.
	 */
	public static void clearTeam() {
		players.clear();
		inventory.clear();
		Money.setMoney(0);
		setPicks(10);
	}
	
	/**
	 * Adds injured players to an injury list
	 */
	public static void teamInjuries() {
	    Iterator<Athlete> iterator = playerTeam.getPlayers().iterator();
	    while (iterator.hasNext()) {
	        Athlete player = iterator.next();
	        player.updateInjured();
	        if (player.getInjured()) {
	            iterator.remove();
	            injuredPlayers.add(player);
	        }
	    }
	    
	    iterator = injuredPlayers.iterator();
	    while (iterator.hasNext()) {
	        Athlete player = iterator.next();
	        player.updateInjured();
	        if (!player.getInjured()) {
	            iterator.remove();
	            playerTeam.getPlayers().add(player);
	        }
	    }
	}
	
	public static void main(String[] args) {
		
	}
}
