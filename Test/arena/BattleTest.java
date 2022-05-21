package Test.arena;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


import main.arena.Battle;
import main.arena.Enemy;
import main.environment.GameEnvironment;
import main.monster.Monster;

class BattleTest {

	public GameEnvironment initial() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		return game;
		
	}

	@Test
	public void winTest() {
		GameEnvironment game =initial();
		Battle testBattle = new Battle(game);
		Enemy enemy = new Enemy(game);
		int initGold = game.getPlayer().getGold();
		int initPoint = game.getPlayer().getPoints();
		testBattle.win(game.getPlayer(), enemy);
		int postGold = game.getPlayer().getGold();
		int postPoint = game.getPlayer().getPoints();
		assertTrue(initGold < postGold);
		assertTrue(initPoint < postPoint);
		
	}
	
	@Test
	public void fightTest() {
		GameEnvironment game =initial();
		Battle testBattle = new Battle(game);
		Enemy enemy = new Enemy(game);
		Monster playmon = game.getPlayer().getSquad().getMonsters().get(0);
		Monster enemmon = enemy.getSquad().getMonsters().get(0);
		testBattle.fight(playmon, enemmon);
		assertFalse(playmon.getIsFainted() == enemmon.getIsFainted());
	}
	
	@Test
	public void setBattleTest() {
		GameEnvironment game =initial();
		Battle testBattle = new Battle(game);
		Enemy enemy = new Enemy(game);
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(enemy);
		String out = testBattle.setBattle(enemies, 0);
		if (out.equals("You lost! all of your monsters fainted.\nUse healer items or sleep to heal your monsters.")) {
			assertTrue(game.getPlayer().getSquad().getMonsters().get(0).getIsFainted());
		}else {
			assertTrue(enemy.getSquad().getMonsters().get(0).getIsFainted());
		}
			
	}
	
}
