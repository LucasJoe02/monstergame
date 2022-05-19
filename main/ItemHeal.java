package main;

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
	private String name = "Healer!";
	
	/**
	 * The description of the item.
	 */
	private String desc;
	/**
	 * The price to buy the item. Defaults to 5.
	 */
	private int purchasePrice = 5;
	/**
	 * The price to sell the item. Defaults to 3.
	 */
	private int resellPrice = 3;
	
	/**
	 * Gets the name of this item.
	 * @return the name of this item.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the purchase price of this item.
	 * @return the purchase price of this item.
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * Gets the resell price of this item.
	 * @return the resell price of this item.
	 */
	public int getResellPrice() {
		return resellPrice;
	}
	
	
	
	/**
	 * Gets the description of the item.
	 * @return the description of the item.
	 */
	public String getDesc() {
		desc = "The "+name+" increases your monster's current health by their current heal amount!";
		return desc;
	}
	
	/**
	 * Calls heal() function for the supplied monster.
	 * @param monster
	 */
	public void useItem(Monster monster) {
		monster.heal();
		
	}
	
	
	
}
