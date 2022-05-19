package main;

import java.util.ArrayList;

public class Battle {
	
	private GameEnvironment game;
	
	
	public Battle(GameEnvironment game) {
		// TODO Auto-generated constructor stub
		this.game = game;
	}

	public void setBattle(ArrayList<Enemy> enList, int index) {
		ArrayList<Monster> playerMons = game.getPlayer().getSquad().getMonsters();
		ArrayList<Monster> enemyMons = enList.get(index).getSquad().getMonsters();
		
		int a = 0;
		int b = 0;
		
		while (playerMons.get(-1).getIsFainted() == false || enemyMons.get(-1).getIsFainted() == false) {
			fight(playerMons.get(a), enemyMons.get(b));
			if (playerMons.get(a).getIsFainted() == true) {
				a +=1;
			}else {
				win(game.getPlayer(), enList.get(index));
				b += 1;
			}
		}
	}
	
	public void fight(Monster player, Monster enemy) {
		while (player.getIsFainted() == false && enemy.getIsFainted() == false) {
			enemy.takeDamage(player.getAttackDamage());
			if (enemy.getIsFainted() == false) {
				player.takeDamage(enemy.getAttackDamage());
			}
		}
	}
	
	public void win(Player player, Enemy enemy) {
		player.increaseGold(enemy.getGold());
		player.increasePoints(enemy.getPoints());
		//add gold 
	}
	
	
}
