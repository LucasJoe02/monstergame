package Test.environment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.item.ItemIncMaxHP;
import main.monster.Monster;

class GameEnvironmentTest {
	
	public GameEnvironment initial() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		return game;
	}

	@Test 
	public void useItemOnMonsterTest() {
		GameEnvironment game =initial();
		ItemIncMaxHP item = new ItemIncMaxHP();
		game.getPlayer().addItem(item);
		int initHP = game.getPlayer().getSquad().getMonsters().get(0).getMaxHealth();
		game.useItemOnMonster(0, 0);
		int postHP = game.getPlayer().getSquad().getMonsters().get(0).getMaxHealth();
		assertTrue(initHP < postHP);
	}
	
	//how test sleep???

}
