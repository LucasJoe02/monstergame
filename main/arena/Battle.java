package main.arena;

import java.util.ArrayList;

import main.environment.GameEnvironment;
import main.monster.Monster;
import main.player.Player;

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
	 * Creates a Battle instance and sets current GameEnvironment being used.
	 * @param game the current GameEnvironment.
	 */
	public Battle(GameEnvironment game) {
		this.game = game;
	}

	/**
	 * Sets up both player and enemy monsters to battle, then calls fight method, and returns a string of the outcome.
	 * @param enList the list of potential enemies from the arena.
	 * @param index the index of enemy to be fought.
	 * @return a string representation of the battle outcome.
	 */
	public String setBattle(ArrayList<Enemy> enList, int index) {
		ArrayList<Monster> playerMons = game.getPlayer().getSquad().getMonsters();
		ArrayList<Monster> enemyMons = enList.get(index).getSquad().getMonsters();
		
		int a = 0;
		int b = 0;
		
		while (playerMons.get(playerMons.size()-1).getIsFainted() == false && enemyMons.get(enemyMons.size()-1).getIsFainted() == false) {
			//call fight
			fight(playerMons.get(a), enemyMons.get(b));
			if (playerMons.get(a).getIsFainted() == true) {
				a +=1;
			}else {
				b += 1;
			}
		}
		String summary;
		if (playerMons.get(playerMons.size()-1).getIsFainted()==false) {
			Enemy enemy = enList.get(index);
			win(game.getPlayer(), enemy);
			int faintedInt = 0;
			for (Monster mons:playerMons) {
				if (mons.getIsFainted()==true) {
					faintedInt+=1;
				}
			}
			summary = "You won! \nYou gained "+enemy.getGold()+" gold and "+enemy.getPoints()+" points. \n"
					  +faintedInt+" of your monsters are now fainted.";
		}else {
			summary = "You lost! all of your monsters fainted. \nUse healer items or sleep to heal your monsters.";
		}
		return summary;
	}
	
	/**
	 * Has a player and enemy monster fight against each other. Enemy will take damage first, and then player until one of the monsters faint.
	 * @param player the monster on the player's team that is to fight.
	 * @param enemy the monster on the enemy's team that is to fight.
	 */
	public void fight(Monster player, Monster enemy) {
		while (player.getIsFainted() == false && enemy.getIsFainted() == false) {
			enemy.takeDamage(player.getAttackDamage());
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
		player.increaseGold(enemy.getGold());
		player.increasePoints(enemy.getPoints());
	}
	
	
}
