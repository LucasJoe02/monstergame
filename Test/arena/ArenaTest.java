package Test.arena;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.arena.Arena;
import main.arena.Enemy;
import main.environment.GameEnvironment;
import main.monster.Monster;

class ArenaTest {

	private GameEnvironment game;
	private Enemy enemy;
	
	public GameEnvironment initial() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		return game;
	}
	
	@Test
	public void refreshOpponentsTest() {
		initial();
		Arena testArena = new Arena(initial());
		testArena.refreshOpponents();
		assertEquals(3, testArena.getEnemies().size());
		assertEquals(Enemy.class, testArena.getEnemies().get(0).getClass());
	}

	@Test
	public void battleTest() {
		initial();
		Arena testArena = new Arena(initial());
		testArena.battle(0);
		assertEquals(2, testArena.getEnemies().size());
	}
	
}
