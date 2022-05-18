/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * This class implements an Arena which organises
 * the currently available enemy players that the
 * user can battle against as well as provide the
 * functionality to start those battles.
 * 
 * @author Lucas Redding
 * @author Celeste Turnock
 * @version 1.1, May 2022.
 */
public class Arena {

	private GameEnvironment game;
	private ArrayList<Enemy> enemies;
	
	
	public Arena(GameEnvironment game) {
		// TODO Auto-generated constructor stub
		this.game = game;
	}
	
	public void refreshOpponents( ) {
		Enemy zero = new Enemy(game);
		Enemy one = new Enemy(game);
		Enemy two = new Enemy(game);
		enemies.add(0, zero);
		enemies.add(1, one);
		enemies.add(2, two);
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	public void battle(Player player, int index) {
		
	}

}
