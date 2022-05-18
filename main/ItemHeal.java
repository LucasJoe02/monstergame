package main;

public class ItemHeal implements Item {

	/**
	 * The name of the item. Defaults to "Healer!"
	 */
	private String name = "Healer!";
	/**
	 * The amount that the monster should heal by.
	 */
	private int increaseAmount;
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
	 * Gets the amount the monster should heal by.
	 * @return the amount the monster should heal by.
	 */
	public int getIncreaseAmount() {
		return increaseAmount;
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
