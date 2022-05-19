package main;

/**
 * This class implements a ItemIncHealSpd which can be used as an item
 * by the player to increase a Monster's current Heal Amount.
 * 
 * @author Celeste Turnock
 * @author Lucas Redding
 * 
 * @version 1.1, May 2022.
 */

public class ItemIncHealSpd implements Item {

	/**
	 * The name of the item. Defaults to "Bounce-back!'
	 */
	private String name;
	/**
	 * The amount the heal amount should increase by.
	 */
	private int increaseAmount;
	/**
	 * The description of the item.
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
	
	public ItemIncHealSpd() {
		name = "Bounce-Back!";
		increaseAmount = 5;
		desc = name + " increases your monster's current heal amount, making it possible to regain more health overnight!";
		purchasePrice = 10;
		resellPrice = 5;
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
	 * Gets the amount the heal amount should increase by.
	 * @return the amount the heal amount should increase by.
	 */
	public int getIncreaseAmount() {
		return increaseAmount;
	}
	
	/**
	 * Gets the description of the item.
	 * @return the description of the item.
	 */
	@Override
	public String getDesc() {;
		return desc;
	}
	
	/**
	 * Gets the purchase price of this item.
	 * @return the purchase price of the item.
	 */
	@Override
	public int getPurchasePrice() {
		purchasePrice = 10;
		return purchasePrice;
	}
	
	/**
	 * Gets the resell price of this item.
	 * @return the resell price of the item.
	 */
	@Override
	public int getResellPrice() {
		resellPrice = 5;
		return resellPrice;
	}
	
	/** 
	 * Calls the increaseHealAmount() for the supplied monster.
	 * @param monster
	 */
	@Override
	public void useItem(Monster monster) {
		monster.increaseHealAmount(increaseAmount);
	}
}
