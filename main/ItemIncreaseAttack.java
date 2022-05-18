package main;

public class ItemIncreaseAttack implements Item{

	/**
	 * The name of the item. Defaults to "Gun!"
	 */
	private String name = "Gun!";
	/**
	 * The amount that the attack amount should increase by.
	 */
	private int increaseAmount;
	/**
	 * The description of the item.
	 */
	private String desc;
	/**
	 * The price to buy the item. Defaults to 10.
	 */
	private int purchasePrice = 10;
	/**
	 * The price to sell the item. Defaults to 5.
	 */
	private int resellPrice;
	
	/**
	 * Gets the name of this item.
	 * @return the name of this item.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the amount that the attack amount should increase by.
	 * @return the amount that the attack amount should increase by.
	 */
	public int getIncreaseAmount() {
		return increaseAmount;
	}
	
	/**
	 * Gets the description of the item.
	 * @return the description of the item.
	 */
	public String getDesc() {
		desc = name + " increases your monster's attack damage, making it possible to cause more damage to your oponent!";
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
	 * Calls increaseAttackDamage() function for the supplied monster.
	 * @param monster
	 */
	public void useItem(Monster monster) {
		monster.increaseAttackDamage(increaseAmount);
		
	}
}
