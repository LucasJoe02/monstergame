package main.item;

import main.monster.Monster;

/**
 * This class implements an ItemIncMaxHP which can be used as an item
 * by the player to increase a Monster's maximum health by a determined amount.
 * 
 * @author Celeste Turnock
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */

public class ItemIncMaxHP implements Item{

	/**
	 * The name of the item.
	 */
	private String name;
	/**
	 * The amount that the monster's max health should increase by"
	 */
	private int increaseAmount;
	/**
	 * The description of this item.
	 */
	private String desc;
	/**
	 * The price to buy the item. Defaults to 10.
	 */
	private int purchasePrice;
	/**
	 * The price to sell the item. Defaults to 5.
	 */
	private int resellPrice;
	
	/**
	 * The default constructor for an ItemIncMaxHP.
	 * Instantiates the variables of this item to its default values.
	 */
	public ItemIncMaxHP() {
		name = "Super Health!";
		increaseAmount = 5;
		desc = name + " increases your monster's current total health amount!";
		purchasePrice = 10;
		resellPrice = 5;
	}
	
	/**
	 * Gets the name of this item.
	 * @return the name of this item.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the amount for the max health to increase by.
	 * @return the amount for the max health to increase by.
	 */
	public int getIncreaseAmount() {
		return increaseAmount;
	}
	 /**
	  * Gets the description of the item.
	  * @return the description of the item.
	  */
	public String getDesc() {
		return desc;
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
	 * Calls increaseMaxHealth() function for the supplied monster.
	 * @param monster the Monster the item is being used on
	 */
	public void useItem(Monster monster) {
		monster.increaseMaxHealth(increaseAmount);
	}
	
	@Override
	public String toStringHTML() {
		return ("<html>"+name+"<br>"+desc);
	}
}
