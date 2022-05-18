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
	 * 
	 */
	private ArrayList<Monster> monsters;
	private ArrayList<Item> stock;
	private MonsterCreator monsterCreator;
	private ItemIncMaxHP itemMax;
	private ItemHeal itemHeal;
	private ItemIncreaseAttack itemAttack;
	private ItemIncHealSpd itemHPSpd;
	private GameEnvironment game;
	
	
	public Shop(GameEnvironment game) {
		this.game = game;
	}
	
	public void refreshStock() {
		monsters.add(0, monsterCreator.createCommon());
		monsters.add(1, monsterCreator.createRare());
		monsters.add(2, monsterCreator.createRandom());
		stock.add(0, itemMax);
		stock.add(1, itemHeal);
		stock.add(2, itemAttack);
		stock.add(3, itemHPSpd);
	}
	
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
	
	public void purchase(int index) {
		 if (index < 3) {
			Monster buy = monsters.get(index);
			int price = buy.getPurchasePrice();
			game.getPlayer().getSquad().addMonster(buy);
			game.getPlayer().decreaseGold(price);
		} else {
			Item ite = stock.get(index-4);
			int price = ite.getPurchasePrice();
			game.getPlayer().addItem(ite);
			game.getPlayer().decreaseGold(price);
			
		}
	}
	
	public void sellMonster(int index) {
		int price =  game.getPlayer().getSquad().getMonsters().get(index).getResellPrice();
		game.getPlayer().increaseGold(price);
		game.getPlayer().getSquad().removeMonster(index);
		
	}
	
	public void sellItem(int index) {
		int price = game.getPlayer().getItems().get(index).getResellPrice();
		game.getPlayer().sellItem(index);
		game.getPlayer().increaseGold(price);
	}

}
