package main;
import java.util.Random;

import javax.swing.DefaultListModel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a matchup between the player team and an opponent
 *
 */
public class Matchup {
	private static OpponentTeam opponentTeam;
	private static Team playerTeam;
	private static int selectedDiff;
	private static int opponentScore;
	private static int playerScore;
	private static int half;
	private static int finalScoreOpp;
	private static int finalScorePlayer;
	
	
	public static OpponentTeam opponent;
	
	/**
	 * Creates a matchup
	 * @param playerTeam the players team
	 * @param opponentTeam the opponent team
	 */
	public Matchup(Team playerTeam, OpponentTeam opponentTeam) {
		opponentTeam = createOpponentTeam();
        this.playerTeam = playerTeam;
        this.opponentTeam = opponentTeam;
		
	}
	
	/**
	 * Returns the final score of the opponent
	 * @return the opponent's score
	 */
	public static int getFinalScoreOpp() {
		return finalScoreOpp;
	}
	
	/**
	 * Sets a new final score for the opponent
	 * @param newFinalScore the new score
	 */
	public static void setFinalScoreOpp(int newFinalScore) {
		finalScoreOpp = newFinalScore;
	}
	
	/**
	 * Gets the final score of the player
	 * @return player's final score
	 */
	public static int getFinalScorePlayer() {
		return finalScorePlayer;
	}
	/**
	 * Sets a new final score for the player
	 * @param newFinalScore the new score
	 */
	public static void setFinalScorePlayer(int newFinalScore) {
		finalScorePlayer = newFinalScore;
	}
	
	/**
	 * Gets the current half
	 * @return half
	 */
	public static int getHalf() {
		return half;
	}
	
	/**
	 * Sets a new half
	 * @param newHalf the new half
	 */
	public static void setHalf(int newHalf) {
		half = newHalf;
	}
	
	/**
	 * Goes to the next half
	 */
	public static void nextHalf() {
		half ++;
	}
	
	/**
	 * Sets the opponent's score
	 * @param points points to be added
	 */
	public static void setOppScore(int points) {
		opponentScore += points;
	}
	
	/**
	 * Generates a score for the opponent over the half
	 * @return the score
	 */
	public static int oppHalfScore() {
	    Random random = new Random();
	    opponentScore = (int) (opponentTeam.getRating() * 0.65);
	    int opponentRandom = random.nextInt(-6, 9);
	    opponentScore += opponentRandom;
	    return opponentScore;
	}
	
	/**
	 * Sets the players new points
	 * @param points points to be added
	 */
	public static void setPlayerScore(int points) {
		playerScore += points;
	}
	
	/**
	 * Generates a score for the players team over the half
	 * @return the score
	 */
	public static int playerHalfScore() {
		int teamRating = playerTeam.getTeamRating();
		Random random = new Random();
		int playerRandom = random.nextInt(-6, 9);
		playerScore = (int) (teamRating * 0.65);
	    for (Athlete player : Team.playerTeam.getStarters()) {
	    	player.setStamina((int) (player.getStamina() - (((0.98/player.getFitness())*1000)/2)));
	    	System.out.print(player.getStamina());
	    	if (player.getStamina() < 0) {
	    		player.setStamina(0);
	    	}
	    }
	    for (Athlete player : Team.playerTeam.getBench()) {
	    	player.setStamina((int) (player.getStamina() + (((0.98/player.getFitness())*1000)/3)));
	    	if (player.getStamina() > 100) {
	    		player.setStamina(100);
	    	}
	    }
	    
	    playerScore += playerRandom;
	    System.out.println(playerScore);
	    return playerScore;	        
	}
	
	/**
	 * Creates an opponent to verse
	 * @return opponent team
	 */
	public static OpponentTeam createOpponentTeam() {
		//selects name
		Random random = new Random();
		ArrayList<String> opponentNames = new ArrayList<String>();
		Collections.addAll(opponentNames, "LA Fakers", "Denver Tenders", "Milwaukee Deer", "Miami Meat", "NY Undies"
				, "Albuquerque Ice", "Philly 69ers", "Houston Starmen", "Chicago Cows", "Auckland Air", "Christchurch Cowboys");
		String opponentName = opponentNames.get(random.nextInt(0, 11));
		opponentTeam = new OpponentTeam(opponentName, 0);
		
		setOpponentRating();
		System.out.println(opponentTeam.getName() + ", Rating - " + opponentTeam.getRating());
		return opponentTeam;
	}
	
	/**
	 * Sets the rating of the opponent
	 */
	public static void setOpponentRating() {
		selectedDiff = PreGame.getDiff();
		if (selectedDiff == -1) {
			opponentTeam.setRating(playerTeam.getTeamRating() - 5);
		}
		else if (selectedDiff == 0) {
			opponentTeam.setRating(playerTeam.getTeamRating());
		}
		else if (selectedDiff == 1) {
			opponentTeam.setRating(playerTeam.getTeamRating() + 5);
		}
		
	}
	
	/**
	 * returns the opponent team
	 * @return opponent team
	 */
	public OpponentTeam getOpponentTeam() {
		return opponentTeam;
	}
	
	/**
	 * gets the players team
	 * @return player team
	 */
	public Team getPlayerTeam() {
		return playerTeam;
	}

	/**
	 * Sets the difficulty of the matchup
	 * @param i the difficulty
	 */
	public void setDifficulty(int i) {
		selectedDiff = i;
	}

	/**
	 * Gets the player's score
	 * @return player score
	 */
	public int getPlayerScore() {
		return playerScore;
	}
}
