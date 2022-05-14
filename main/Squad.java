/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author Lucas Redding
 *
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
