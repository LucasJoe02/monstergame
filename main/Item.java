package main;

/**
 * This interface defines the functionality required
 * for the items to be used correctly by the wider 
 * project.
 * 
 * @author Celeste Turnock
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public interface Item {

	/**
	 * Gets the purchase price of the item.
	 * @return the purchase price.
	 */
	int getPurchasePrice();
	/**
	 * Gets the resell price of the item.
	 * @return the resell price.
	 */
	int getResellPrice();
	/**
	 * Gets the name of the item.
	 * @return the name of the item.
	 */
	String getName();
	/**
	 * Gets the description of the item.
	 * @return the description of the item.
	 */
	String getDesc();
	/**
	 * Uses the item on the given monster.
	 * @param monster the given monster.
	 */
	void useItem(Monster monster);
}
