/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author Lucas Redding
 *
 */
public class Player {
	
	String name;
	int gold;
	int points;
	Squad squad;
	ArrayList<Item> items;


	/**
	 * 
	 */
	public Player() {
		points = 0;
		gold = 0;
		squad = new Squad();
		items = new ArrayList<Item>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void increaseGold(int gold) {
		this.gold += gold;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void increasePoints(int addPoints) {
		points += addPoints;
	}
	
	public Squad getSquad() {
		return squad;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void addItem(Item newItem) {
		items.add(newItem);
	}
	
	public String itemsString() {
		String itemsString = new String();
		for (int index = 0; index < items.size(); index++) {
			itemsString += index+". "+items.get(index).getName()+"\n";
		}
		return itemsString;
	}
	
	public void sellItem(int itemIndex) {
		increaseGold(items.get(itemIndex).getResellPrice());
		items.remove(itemIndex);
	}

//	public static void main(String[] args) {
//		Player player = new Player();
//		Item item = new Item();
//		player.addItem(item);
//		player.addItem(item);
//		System.out.println(player.itemsString());
//
//	}

}
