/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * This class implements a Shop which provides the
 * functionality for the user to buy and sell purchasable
 * items and monsters for gold.
 * 
 * @author Lucas Redding
 * @author Celeste Turnock
 * @version 1.1, May 2022.
 */
public class Shop {
	
	

	/**
	 * An ArrayList of monsters to sell.
	 */
	private ArrayList<Monster> monsters;
	/**
	 * An ArrayList of items to sell.
	 */
	private ArrayList<Item> stock;
	/**
	 * A monster creator to generate new monsters.
	 */
	private MonsterCreator monsterCreator;
	/**
	 * An ItemIncMaxHP to sell to the player.
	 */
	private ItemIncMaxHP itemMax;
	/**
	 * An ItemHeal to sell to the player.
	 */
	private ItemHeal itemHeal;
	/**
	 * An ItemIncreaseAttack to sell to the player.
	 */
	private ItemIncreaseAttack itemAttack;
	/**
	 * An ItemIncHealSpd to sell to the player.
	 */
	private ItemIncHealSpd itemHPSpd;
	/**
	 * A GameEnvironment to link back to current GameEnvironment.
	 */
	private GameEnvironment game;
	
	/**
	 * Creates a Shop instance and calls current GameEnvironment being used.
	 * @param game the current GameEnvironment
	 */
	public Shop(GameEnvironment game) {
		this.game = game;
		monsters = new ArrayList<Monster>();
		stock = new ArrayList<Item>();
		refreshStock();
	}
	
	/**
	 * Refreshes stock for the player to buy from.
	 * Generates a common, rare and random monster then adds them to an ArrayList to be displayed.
	 * Adds items to ArrayList to be displayed.
	 */
	public void refreshStock() {
		monsters.set(0, monsterCreator.createCommon());
		monsters.set(1, monsterCreator.createRare());
		monsters.set(2, monsterCreator.createRandom());
		stock.set(0, itemMax);
		stock.set(1, itemHeal);
		stock.set(2, itemAttack);
		stock.set(3, itemHPSpd);
	}
	
	/**
	 * Prints out name and description for all items that are available for purchase.
	 */
	public void displayStock() {
		int num = 0;
		System.out.println("Welcome to the Store! Below is everything available to purchase!");
		for (Monster q:monsters) {
			String desc =q.getDesc();
			System.out.println(num + desc);
			num+= 1;
		}
		for (Item p:stock) {
			String desc = p.getDesc();
			System.out.println(num + desc);
			num += 1;
		}
		
		
	}
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	public ArrayList<Item> getItems() {
		return stock;
	}
	
	
	/**
	 * Facilitates the purchase of either a monster or item from the shop.
	 * If the player chooses a monster, it is added to their squad and the gold is removed from their total.
	 * If the player chooses an item, it is added to their inventory and the gold is removed from their total.
	 * @param index the index of item to be purchased as described by displayStock() 
	 */
	public void purchase(int index) {
		 if (index < 3) {
			Monster buy = monsters.get(index);
			int price = buy.getPurchasePrice();
			game.getPlayer().getSquad().addMonster(buy);
			game.getPlayer().decreaseGold(price);
		} else {
			Item ite = stock.get(index-3);
			int price = ite.getPurchasePrice();
			game.getPlayer().addItem(ite);
			game.getPlayer().decreaseGold(price);
			
		}
	}
	
	/**
	 * Facilitates the selling of monsters back to the shop.
	 * The monster is removed from the player's squad, and the gold is added to their total.
	 * @param index the index of the monster in the player's squad.
	 */
	public void sellMonster(int index) {
		int price =  game.getPlayer().getSquad().getMonsters().get(index).getResellPrice();
		game.getPlayer().increaseGold(price);
		game.getPlayer().getSquad().removeMonster(index);
		
	}
	
	/**
	 * Facilitates the selling of items back to the shop.
	 * The item is removed from the player's inventory, and the gold is added to their total.
	 * @param index the index of the item in the player's inventory.
	 */
	public void sellItem(int index) {
		int price = game.getPlayer().getItems().get(index).getResellPrice();
		game.getPlayer().sellItem(index);
		game.getPlayer().increaseGold(price);
	}

}
