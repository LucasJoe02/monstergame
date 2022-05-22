package main.item;

import main.monster.Monster;

/**
 * This class implements an ItemHeal which can be used as an item
 * by the player to heal their Monsters.
 * 
 * @author Celeste Turnock
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */

public class ItemHeal implements Item {

	/**
	 * The name of the item. Defaults to "Healer!"
	 */
	private String name;
	
	/**
	 * The description of the item.
	 */
	private String desc;
	/**
	 * The price to buy the item. Defaults to 5.
	 */
	private int purchasePrice;
	/**
	 * The price to sell the item. Defaults to 3.
	 */
	private int resellPrice;
	
	/**
	 * The default constructor for an ItemHeal.
	 * Instantiates the variables of this item to its default values.
	 */
	public ItemHeal() {
		name = "Healer!";
		desc = "The "+name+" increases your monster's current health by their current heal amount!";
		purchasePrice = 5;
		resellPrice = 3;
	}
	
	/**
	 * Gets the name of this item.
	 * @return the name of this item.
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the purchase price of this item.
	 * @return the purchase price of this item.
	 */
	@Override
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * Gets the resell price of this item.
	 * @return the resell price of this item.
	 */
	@Override
	public int getResellPrice() {
		return resellPrice;
	}
	
	/**
	 * Gets the description of the item.
	 * @return the description of the item.
	 */
	@Override
	public String getDesc() {
		return desc;
	}
	
	/**
	 * Calls heal() function for the supplied monster.
	 * @param monster the Monster the item is being used on
	 */
	@Override
	public void useItem(Monster monster) {
		monster.heal();
		
	}
	
	@Override
	public String toStringHTML() {
		return ("<html>"+desc);
	}
}
