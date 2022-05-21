package Test.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.item.ItemIncHealSpd;
import main.item.ItemIncMaxHP;
import main.monster.Monster;

class ItemIncMaxHPTest {

	public GameEnvironment initial() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		return game;
	}
	
	@Test
	public void useItemTest() {
		GameEnvironment game =initial();
		ItemIncMaxHP testItem = new ItemIncMaxHP();
		int initHP = game.getPlayer().getSquad().getMonsters().get(0).getMaxHealth();
		testItem.useItem(game.getPlayer().getSquad().getMonsters().get(0));
		int postHP = game.getPlayer().getSquad().getMonsters().get(0).getMaxHealth();
		assertTrue(initHP < postHP);
	}

}
