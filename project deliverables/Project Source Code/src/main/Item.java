package main;

/**
 * Represents an Item in the game
 *
 */
public abstract class Item extends Purchasable {
	public String itemType;
	public String description;
	
	/**
	 * Instantiates the Item.
	 * @param itemType The name of the item
	 * @param description The item description
	 * @param contractPrice The contract price of the item
	 * @param sellBackPrice The sell back price of the item
	 */
	public Item(String itemType, String description, int contractPrice, int sellBackPrice) {
		super(itemType, contractPrice, sellBackPrice, description);
		this.itemType = itemType;
		this.description = description;
	}
	/**
	 * Returns the item type
	 * @return item type
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * Get the description of the item
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Consumes the item on an Athlete.
	 * @param athlete The athlete
	 */
	
	public abstract void consume(Athlete athlete);
}
