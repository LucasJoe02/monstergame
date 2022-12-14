package main.shop;

import java.util.ArrayList;

import main.environment.GameEnvironment;
import main.item.Item;
import main.item.ItemHeal;
import main.item.ItemIncHealSpd;
import main.item.ItemIncMaxHP;
import main.item.ItemIncreaseAttack;
import main.monster.Monster;
import main.monster.MonsterCreator;

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
		monsterCreator = new MonsterCreator();
		refreshStock();
	}
	
	
	/**
	 * Refreshes stock for the player to buy from.
	 * Generates a common, rare and random monster then adds them to an ArrayList to be displayed.
	 * Adds items to ArrayList to be displayed.
	 */
	public void refreshStock() {
		monsters.clear();
		stock.clear();
		monsters.add(0, monsterCreator.createCommon());
		monsters.add(1, monsterCreator.createRare());
		monsters.add(2, monsterCreator.createRandom());
		stock.add(0, new ItemIncMaxHP());
		stock.add(1, new ItemHeal());
		stock.add(2, new ItemIncreaseAttack());
		stock.add(3, new ItemIncHealSpd());
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
	
	/**
	 * Gets the list of monsters for this shop.
	 * @return the ArrayList of monsters for this shop
	 */
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	/**
	 * Gets the list of items for this shop.
	 * @return the ArrayList of items for this shop
	 */
	public ArrayList<Item> getItems() {
		return stock;
	}
	
	
	/**
	 * Facilitates the purchase of a monster from the shop.
	 * If the player chooses a monster, it is added to their squad and the gold is removed from their total.
	 * @param index the index of monster to be purchased.
	 */
	public void purchaseMonster(int index) {
		Monster buy = monsters.get(index);
		int price = buy.getPurchasePrice();
		game.getPlayer().getSquad().addMonster(buy);
		monsters.remove(buy);
		game.getPlayer().decreaseGold(price);

	}
	
	/**
	 * Facilitates the purchase of an item from the shop.
	 * If the player chooses a item, it is added to their inventory and the gold is removed from their total.
	 * @param index the index of item to be purchased.
	 */
	public void purchaseItem(int index) {
		Item ite = stock.get(index);
		int price = ite.getPurchasePrice();
		game.getPlayer().addItem(ite);
		stock.remove(ite);
		game.getPlayer().decreaseGold(price);
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
