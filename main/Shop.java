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
 * @version 1.1, May 2022.
 */
public class Shop {

	/**
	 * 
	 */
	private ArrayList<Purchasable> stock;
	private MonsterCreator monsterCreator;
	private ItemIncMaxHP itemMax;
	private ItemHeal itemHeal;
	private ItemIncreaseAttack itemAttack;
	private ItemIncHealSpd itemHPSpd;
	
	
	public void refreshStock() {
		stock.add(0, monsterCreator.createCommon());
		stock.add(1, monsterCreator.createRare());
		stock.add(2, monsterCreator.createRandom());
		stock.add(3, itemMax);
		stock.add(4, itemHeal);
		stock.add(5, itemAttack);
		stock.add(6, itemHPSpd);
	}
	
	public void displayStock() {
		
	}
	
	public void purchase(Purchasable product) {
		
	}

}
