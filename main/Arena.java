/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * This class implements an Arena which organizes
 * the currently available enemy players that the
 * user can battle against as well as provide the
 * functionality to start those battles.
 * 
 * @author Celeste Turnock
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class Arena {

	/**
	 * A GameEnvironment to link back to the GameEnvironment currently in use.
	 */
	private GameEnvironment game;
	/**
	 * An ArrayList of possible enemies for the player to face.
	 */
	private ArrayList<Enemy> enemies;
	/**
	 * A Battle to facilitate fights between combatants.
	 */
	private Battle battle;
	
	/**
	 * Creates an Arena instance and calls current GameEnvironment being used.
	 * @param game the current GameEnvironment
	 */
	public Arena(GameEnvironment game) {
		this.game = game;
		battle = new Battle(game);
		refreshOpponents();
	}
	
	
	/**
	 * Refreshes opponents for the player to face.
	 * Generates three enemies then adds them to an ArrayList to be displayed.
	 */
	public void refreshOpponents() {
		Enemy zero = new Enemy(game);
		Enemy one = new Enemy(game);
		Enemy two = new Enemy(game);
		enemies.clear();
		enemies.add(0, zero);
		enemies.add(1, one);
		enemies.add(2, two);
	}
	
	/**
	 * Gets the ArrayList of enemies.
	 * @return the ArrayList of enemies.
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	/**
	 * Initiates the battle between the player's squad and the chosen enemy's squad.
	 * @param enemyIndex the integer index of the chosen enemy to face.
	 */
	public void battle(int enemyIndex) {
		battle.setBattle(enemies, enemyIndex);
	}

}
