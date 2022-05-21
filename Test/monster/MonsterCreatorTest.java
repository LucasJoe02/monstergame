package Test.monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.monster.Monster;
import main.monster.MonsterCreator;

class MonsterCreatorTest {
	
	private MonsterCreator monsterCreator;

	public GameEnvironment initial() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		return game;
		
	}
	
	@Test
	public void createCommonTest() {
		MonsterCreator monsterCreator = new MonsterCreator();
		Monster def1 = monsterCreator.createCommon();
		//assertTrue(def.getLevel);
		assertTrue(def1.getMaxHealth() >= 9 && def1.getMaxHealth() <= 31);
		assertTrue(def1.getAttackDamage() >=4 && def1.getAttackDamage() <= 11);
		//assertTrue(def.getHealAmount);
		assertEquals(def1.getRarity(), "Common");
	}
	
	
	@Test
	public void createRareTest() {
		MonsterCreator monsterCreator = new MonsterCreator();
		Monster def2 = monsterCreator.createRare();
		//assertTrue(def.getLevel);
		assertTrue(def2.getMaxHealth() >= 19 && def2.getMaxHealth() <= 41);
		//assertTrue(def2.getAttackDamage() >=9 && def2.getAttackDamage() <= 16);
		//assertTrue(def.getHealAmount);
		assertEquals(def2.getRarity(), "Rare");
	}
	
	@Test
	public void createSuperEpicTest() {
		MonsterCreator monsterCreator = new MonsterCreator();
		Monster def3 = monsterCreator.createSuperEpic();
		//assertTrue(def.getLevel);
		assertTrue(def3.getMaxHealth() >= 39 && def3.getMaxHealth() <= 61);
		//assertTrue(def3.getAttackDamage() >=19 && def3.getAttackDamage() <= 31);
		//assertTrue(def.getHealAmount);
		assertEquals(def3.getRarity(), "Super Epic");
	}

}
