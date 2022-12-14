package main.item;

import main.monster.Monster;

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
	 * Gets the purchase price of this item.
	 * @return the integer purchase price.
	 */
	public int getPurchasePrice();
	/**
	 * Gets the resell price of this item.
	 * @return the integer resell price.
	 */
	public int getResellPrice();
	/**
	 * Gets the name of this item.
	 * @return the String name of this item.
	 */
	public String getName();
	/**
	 * Gets the description of this item.
	 * @return the String description of this item.
	 */
	public String getDesc();
	/**
	 * Uses this item on the given monster.
	 * @param monster the given monster.
	 */
	public void useItem(Monster monster);
	
	/**
	 * Returns the name and description of this item in html.
	 * @return the String name and description of this item in html.
	 */
	public String toStringHTML();
}
