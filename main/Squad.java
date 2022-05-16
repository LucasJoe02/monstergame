/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * This class implements a Squad of Monsters that
 * is owned by an instance of the player class.
 * The squad holds the Monsters that will fight in
 * battles for the player.
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class Squad {

	ArrayList<Monster> monsters;
	
	/**
	 * 
	 */
	public Squad() {
		monsters = new ArrayList<Monster>();
	}
	
	public ArrayList<Monster> getMonsters(){
		return monsters;
	}
	
	public void addMonster(Monster newMonster) {
		monsters.add(newMonster);
	}

}
