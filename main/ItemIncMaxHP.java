package main;

public class ItemIncMaxHP implements Item{

	/**
	 * The name of the item. Defaults to "Super Health!"
	 */
	private String name = "Super Health!";
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
	private int purchasePrice = 10;
	/**
	 * The price to sell the item. Defaults to 5.
	 */
	private int resellPrice = 5;
	
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
		desc = name + " increases your monster's current total health amount!";
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
	 * @param monster
	 */
	public void useItem(Monster monster) {
		monster.increaseMaxHealth(increaseAmount);
	}
	
}
