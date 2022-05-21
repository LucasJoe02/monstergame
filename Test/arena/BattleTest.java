package Test.arena;

import static org.junit.jupiter.api.Assertions.*;

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
	
}
