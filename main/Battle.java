package main;

import java.util.ArrayList;

/**
 * This class implements a Battle which dictates how a fight
 * is run and consequently.
 * In a battle, the player and enemy monsters take turns damaging
 * each other until either faints.
 * 
 * @author Celeste Turnock
 * @author Lucas Redding
 * @version 1.1, May 2022
 */

public class Battle {
	
	/**
	 * A GameEnvironment to call back to current game environment.
	 */
	private GameEnvironment game;
	
	/**
	 * Creates a Battle instance and calls current GameEnvironment being used.
	 * @param game the current GameEnvironment.
	 */
	public Battle(GameEnvironment game) {
		// TODO Auto-generated constructor stub
		this.game = game;
	}

	/**
	 * Sets up both player and enemy monsters to battle, then calls fight class.
	 * @param enList the list of potential enemies from the arena.
	 * @param index the index of enemy to be fought.
	 */
	public void setBattle(ArrayList<Enemy> enList, int index) {
		//method takes in ArrayList of current enemies, and the index of the enemy to be fought
		// gets players squad
		ArrayList<Monster> playerMons = game.getPlayer().getSquad().getMonsters();
		//gets enemy's squad
		ArrayList<Monster> enemyMons = enList.get(index).getSquad().getMonsters();
		
		//index of player monster
		int a = 0;
		//index of enemy monster
		int b = 0;
		
		//while there are still monsters awake on both teams
		while (playerMons.get(playerMons.size()-1).getIsFainted() == false || enemyMons.get(enemyMons.size()-1).getIsFainted() == false) {
			//call fight
			fight(playerMons.get(a), enemyMons.get(b));
			if (playerMons.get(a).getIsFainted() == true) {
				//if player loses, get next monster.
				a +=1;
			}else {
				//if player wins, get points and gold
				win(game.getPlayer(), enList.get(index));
				//get next enemy monster
				b += 1;
			}
		}
	}
	
	/**
	 * Has a player and enemy monster fight against each other. Enemy will take damage first, and then player until one of the monsters faint.
	 * @param player the monster on the player's team that is to fight.
	 * @param enemy the monster on the enemy's team that is to fight.
	 */
	public void fight(Monster player, Monster enemy) {
		//while both monsters are awake
		while (player.getIsFainted() == false && enemy.getIsFainted() == false) {
			//the enemy takes damage
			enemy.takeDamage(player.getAttackDamage());
			//if enemy is awake, the player takes damage
			if (enemy.getIsFainted() == false) {
				player.takeDamage(enemy.getAttackDamage());
			}
		}
	}
	
	/**
	 * Expresses what happen when a player's squad is able to win a fight.
	 * @param player the current player.
	 * @param enemy the current enemy.
	 */
	public void win(Player player, Enemy enemy) {
		//give player gold and points.
		player.increaseGold(enemy.getGold());
		player.increasePoints(enemy.getPoints());
	}
	
	
}
