package Test.environment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.arena.Enemy;
import main.environment.GameEnvironment;
import main.item.ItemIncMaxHP;
import main.monster.Monster;

class GameEnvironmentTest {
	
	

	@Test 
	public void useItemOnMonsterTest() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		ItemIncMaxHP item = new ItemIncMaxHP();
		game.getPlayer().addItem(item);
		int initHP = game.getPlayer().getSquad().getMonsters().get(0).getMaxHealth();
		game.useItemOnMonster(0, 0);
		int postHP = game.getPlayer().getSquad().getMonsters().get(0).getMaxHealth();
		assertTrue(initHP < postHP);
	}
	

	@Test
	public void sleepTest() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		Monster mon1 = game.getShop().getMonsters().get(0);
		Enemy enem1 = game.getArena().getEnemies().get(0);
		game.getPlayer().getSquad().getMonsters().get(0).takeDamage(5);
		int health1 = game.getPlayer().getSquad().getMonsters().get(0).getHealth();
		int numMons = game.getPlayer().getSquad().getMonsters().size();
		String strn = game.sleep();
		assertFalse(mon1 == game.getShop().getMonsters().get(0));
		assertFalse(enem1 == game.getArena().getEnemies().get(0));
		assertTrue(health1 < game.getPlayer().getSquad().getMonsters().get(0).getHealth());
		
		if(strn.contains("away!") && strn.contains("overnight!")) {}
		else {
		
		if(strn.contains("away!")) {
			assertTrue(numMons > game.getPlayer().getSquad().getMonsters().size());
		}
		if(strn.contains("overnight!")){
			assertTrue(numMons < game.getPlayer().getSquad().getMonsters().size());
		}}
		
	}

}
