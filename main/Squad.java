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

	/** 
	 * A list of Monsters associated with this squad.
	 */
	ArrayList<Monster> monsters;
	
	/**
	 * Instantiates the variables for this Squad.
	 */
	public Squad() {
		monsters = new ArrayList<Monster>();
	}
	
	/** 
	 * Gets the list of Monsters in this Squad.
	 * @return list of Monsters in this squad.
	 */
	public ArrayList<Monster> getMonsters(){
		return monsters;
	}
	
	/** 
	 * Adds a given Monster to this squad.
	 * @param newMonster the new Monster to be added to this squad.
	 */
	public void addMonster(Monster newMonster) {
		monsters.add(newMonster);
	}

}
