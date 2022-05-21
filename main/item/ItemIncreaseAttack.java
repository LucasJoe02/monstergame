package main.item;

import main.monster.Monster;

/**
 * This class implements an ItemIncreaseAttack which can be used as an item
 * by the player to increase the attack of their Monsters.
 * 
 * @author Celeste Turnock
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */

public class ItemIncreaseAttack implements Item{

	/**
	 * The name of the item. Defaults to "Gun!"
	 */
	private String name;
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
	private int purchasePrice;
	/**
	 * The price to sell the item. Defaults to 5.
	 */
	private int resellPrice;
	
	/**
	 * The default constructor for an ItemIncreaseAttack.
	 * Instantiates the variables of this item to its default values.
	 */
	public ItemIncreaseAttack() {
		name = "Gun!";
		increaseAmount = 5;
		desc = name + " increases your monster's attack damage, making it possible to cause more damage to your opponent!";
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
	@Override
	public String getDesc() {
		return desc;
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
	 * Calls increaseAttackDamage() function for the supplied monster.
	 * @param monster the Monster the item is being used on
	 */
	@Override
	public void useItem(Monster monster) {
		monster.increaseAttackDamage(increaseAmount);
		
	}
	
	@Override
	public String toStringHTML() {
		return ("<html>"+name+"<br>"+desc);
	}
}
