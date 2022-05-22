package Test.arena;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.arena.Enemy;
import main.environment.GameEnvironment;
import main.monster.Monster;

class EnemyTest {

	
	
	@Test
	public void setSquadTest() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		Enemy enemy1 = new Enemy(game);
		enemy1.getSquad().getMonsters().clear();
		enemy1.setSquad();
		assertTrue(enemy1.getSquad().getMonsters().size() <= 2);
		game.setDay(7);
		enemy1.getSquad().getMonsters().clear();
		enemy1.setSquad();
		assertTrue(enemy1.getSquad().getMonsters().size() <= 4);
		game.setDay(14);
		game.setDifficulty(2);
		enemy1.getSquad().getMonsters().clear();
		enemy1.setSquad();
		assertTrue(enemy1.getSquad().getMonsters().get(enemy1.getSquad().getMonsters().size()-1).getRarity()=="Super Epic");
	}
	

}
