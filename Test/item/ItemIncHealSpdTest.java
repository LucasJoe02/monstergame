package Test.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.item.ItemHeal;
import main.item.ItemIncHealSpd;
import main.monster.Monster;

class ItemIncHealSpdTest {

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
		ItemIncHealSpd testItem = new ItemIncHealSpd();
		int initHP = game.getPlayer().getSquad().getMonsters().get(0).getHealAmount();
		testItem.useItem(game.getPlayer().getSquad().getMonsters().get(0));
		int postHP = game.getPlayer().getSquad().getMonsters().get(0).getHealAmount();
		assertTrue(initHP < postHP);
	}
	
	@Test
	public void toStringHTMLTest() {
		ItemIncHealSpd testItem = new ItemIncHealSpd();
		String testString = testItem.toStringHTML();
		assertEquals(testString, "<html>"+testItem.getDesc());
	}

}
