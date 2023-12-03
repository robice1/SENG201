package main;

/**
 * Represents a purchasable object in the game
 *
 */
public abstract class Purchasable {
	private String name;
	private static int contractPrice;
	private int sellBackPrice;
	private String description;
	
	/**
	 * Instantiates the purchasable
	 * @param name name
	 * @param contractPrice
	 * @param sellBackPrice
	 * @param description
	 */
	public Purchasable(String name, int contractPrice, int sellBackPrice, String description) {
		this.name = name;
		this.contractPrice = contractPrice;
		this.sellBackPrice = sellBackPrice;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return String.format("%s",name);
	}
	
	/**
	 * Gets the name of the object
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets the contract price of the object
	 * @return contract price
	 */
	public static int getContractPrice() {
		return contractPrice;
	}
	
	/**
	 * gets the sell back price of the object
	 * @return sell back price
	 */
	public int getSellBackPrice() {
		return sellBackPrice;
	}
	
	/**
	 * Gets the description of the object
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the name
	 * @param name
	 */
	public void setName(String name) {
	    this.name = name;
	}
	
	/**
	 * Sets the contract price of the object
	 * @param contractPrice
	 */
	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}
	
	/**
	 * Sets the sell back price of the object
	 * @param sellBackPrice
	 */
	public void setSellBackPrice(int sellBackPrice) {
		this.sellBackPrice = sellBackPrice;
	}
	
	/**
	 * Sets the description of the object
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Use
	 */
	public void use() {
		
		
	}
}
