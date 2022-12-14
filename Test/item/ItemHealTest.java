package Test.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.item.ItemHeal;
import main.item.ItemIncreaseAttack;
import main.monster.Monster;

class ItemHealTest {

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
		ItemHeal testItemHeal = new ItemHeal();
		game.getPlayer().getSquad().getMonsters().get(0).takeDamage(3);
		int initHP = game.getPlayer().getSquad().getMonsters().get(0).getHealth();
		testItemHeal.useItem(game.getPlayer().getSquad().getMonsters().get(0));
		int postHP = game.getPlayer().getSquad().getMonsters().get(0).getHealth();
		assertTrue(initHP < postHP);
	}
	//use Items 
	
	@Test
	public void toStringHTMLTest() {
		ItemHeal testItem = new ItemHeal();
		String testString = testItem.toStringHTML();
		assertEquals(testString, "<html>"+testItem.getDesc());
	}

}
