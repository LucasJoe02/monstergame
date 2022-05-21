package main.player;

import java.util.ArrayList;

import main.item.Item;
import main.monster.Squad;

/**
 * This class implements a Player which stores all
 * of the information about the person currently 
 * playing the game or an in game enemy of the person.
 * The player has a squad of Monsters that it uses to
 * fight against the squad of an enemy in order to earn
 * points and gold.
 * 
 * @author Lucas Redding
 * @author Celeste Turnock
 * @version 1.1, May 2022.
 */
public class Player {
	
	/** 
	 * The name of this player.
	 */
	private String name;
	/** 
	 * The amount of gold this player has.
	 */
	private int gold;
	/** 
	 * The amount of points this player has.
	 */
	private int points;
	/** 
	 * The Squad of Monsters associated with this player.
	 */
	private Squad squad;
	/** 
	 * The list of items that this player has.
	 */
	private ArrayList<Item> items;


	/**
	 * The default constructor for a player.
	 * Instantiates the variables of this player to their default values.
	 */
	public Player() {
		points = 0;
		gold = 0;
		squad = new Squad();
		items = new ArrayList<Item>();
	}
	
	/** 
	 * Gets the name of this player.
	 * @return the name of this player.
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * Sets the name of this player.
	 * @param name the new name for this player.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * Gets the amount of gold of this player.
	 * @return the amount of gold of this player.
	 */
	public int getGold() {
		return gold;
	}
	
	/** 
	 * Increases the gold of this player by a given amount.
	 * @param gold the amount of gold to increase by.
	 */
	public void increaseGold(int gold) {
		this.gold += gold;
	}
	
	/**
	 * Decrease the gold of this player by a given amount.
	 * @param gold the amount of gold to decrease by.
	 */
	public void decreaseGold(int gold) {
		this.gold -= gold;
	}
	
	/** 
	 * Gets the points of this player.
	 * @return the points of this player.
	 */
	public int getPoints() {
		return points;
	}
	
	/** 
	 * Increase the points of this player by a given amount.
	 * @param addPoints the amount of points to add to this player's points.
	 */
	public void increasePoints(int addPoints) {
		points += addPoints;
	}
	
	/** 
	 * Gets the squad of this player.
	 * @return the squad of this player.
	 */
	public Squad getSquad() {
		return squad;
	}
	
	/** 
	 * Gets the list of items of this player.
	 * @return list of items of this player.
	 */
	public ArrayList<Item> getItems(){
		return items;
	}
	
	/** 
	 * Add and item to the list of items of this player.
	 * @param newItem the item to add to the list of items of this player.
	 */
	public void addItem(Item newItem) {
		items.add(newItem);
	}
	
	/** 
	 * Returns the items of this player as a string with the indexes of the item.
	 * @return string of items and indexes.
	 */
	public String itemsString() {
		String itemsString = new String();
		for (int index = 0; index < items.size(); index++) {
			itemsString += index+". "+items.get(index).getName()+"\n";
		}
		return itemsString;
	}
	
	/** 
	 * Removes the item at a given index from this player's list of items.
	 * @param itemIndex the index of the item, in the plyaer's list of items, being sold.
	 */
	public void sellItem(int itemIndex) {
		items.remove(itemIndex);
	}

}
