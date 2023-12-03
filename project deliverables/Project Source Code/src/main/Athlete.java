package main;

import java.util.Random;

/**
 * 
 * Represents an Athlete in the game
 *
 */
public class Athlete extends Purchasable{
	Random random = new Random();
	private String name;
	private int stamina = 100;
	private int fitness = (int) random.nextGaussian(75, 15);
	private int offense = (int) random.nextGaussian(75, 15);
	private int defense = (int) random.nextGaussian(75, 15);
	public int overall = (int) (fitness + defense + offense) / 3;
	private boolean injured = false;
	public int 	price = (overall - 40) * 10000;
	
		
	/**
	 * Creates an instance of athlete
	 * @param name the name of the athlete
	 */
	public Athlete(String name) {
		super(name, 0, 0, "Athlete");
		this.name = name;
		setPrices();
		
	}
        
	/**
	 * Formats each athlete in a string
	 */
	@Override
    public String toString() {
    	return String.format("%s | Rating: %d | Value: $%d | Stamina: %d", name, overall, price, stamina);
    }
    
	/**
	 * sets the price of the athlete
	 */
	public void setPrices() {
		price = (getOverall() - 40) * 10000;
		setContractPrice(price);
		setSellBackPrice((int) (price * 0.8));
	}
	/**
	 * gets the price of the athlete
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Returns the name of the athlete
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets a new name for the athlete
	 */
	public void setName(String nickname) {
		name = nickname;
	}
	/**
	 * gets the fitness stat of an athlete
	 *
	 * @return the fitness stat
	 */
	public int getFitness() {
		return fitness;
	}
	/**
	 * sets a new fitness stat
	 * @param newFitness the new stat
	 */
	public void setFitness(int newFitness) {
		fitness = newFitness;
	}
	/**
	 * gets the stamina stat of an athlete
	 * @return the athletes stamina
	 */
	public int getStamina() {
		return stamina;
	}
	/**
	 * Sets the new stamina stat
	 * @param newStamina the new stamina
	 */
	public void setStamina(int newStamina) {
		stamina = newStamina;
	}
	/**
	 * gets the athletes overall rating
	 * 
	 * @return the athletes overall
	 */
	public int getOverall() {
		return overall;
	}
	/**
	 * sets the athletes overall stat
	 * 
	 * @param fitnessStat the fitness stat
	 * @param defenseStat the defense stat
	 * @param offenseStat the offense stat
	 */
	public void setOverall(int fitnessStat, int defenseStat, int offenseStat) {
		overall = (int) (fitness + defense + offense) / 3;
	}
	/**
	 * returns the offense stat
	 * @return the offense stat
	 */
	public int getOffense() {
		return offense;
	}
	
	/**
	 * Sets the new offense stat
	 * 
	 * @param offenseStat the new stat
	 */
	public void setOffense(int offenseStat) {
		offense = offenseStat;
	}
	/**
	 * returns the defense stat
	 * @return the defense stat
	 */
	public int getDefense() {
		return defense;
	}
	/**
	 * sets the defense stat
	 * @param defenseStat the new stat
	 */
	public void setDefense(int defenseStat) {
		defense = defenseStat;
	}
	/**
	 * Updates if a player is injured or not
	 */
	public void updateInjured() {
		if (stamina <= 0) {
			injured = true;
		} else {
			injured = false;
		}
	}

	/**
	 * Gets an athletes injury status
	 * 
	 * @return injury boolean
	 */
	public boolean getInjured() {
		return injured;
	}
	/**
	 * sets an athlete's injury status
	 * @param injury injury status
	 */
	public void setInjured(boolean injury) {
		injured = injury;
	}
	
	public static void main(String[] args) {

		
	}
}
