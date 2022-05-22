package Test.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.item.ItemIncHealSpd;
import main.item.ItemIncMaxHP;
import main.item.ItemIncreaseAttack;
import main.monster.Monster;

class ItemIncreaseAttackTest {

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
		ItemIncreaseAttack testItem = new ItemIncreaseAttack();
		int initHP = game.getPlayer().getSquad().getMonsters().get(0).getAttackDamage();
		testItem.useItem(game.getPlayer().getSquad().getMonsters().get(0));
		int postHP = game.getPlayer().getSquad().getMonsters().get(0).getAttackDamage();
		assertTrue(initHP < postHP);
	}

	@Test
	public void toStringHTMLTest() {
		ItemIncreaseAttack testItem = new ItemIncreaseAttack();
		String testString = testItem.toStringHTML();
		assertEquals(testString, "<html>"+testItem.getDesc());
	}
	
}
