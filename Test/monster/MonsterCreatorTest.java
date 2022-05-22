package Test.monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.monster.Monster;
import main.monster.MonsterCreator;

class MonsterCreatorTest {
	
	private MonsterCreator monsterCreator;

	
	@Test
	public void createCommonTest() {
		MonsterCreator monsterCreator = new MonsterCreator();
		Monster def1 = monsterCreator.createCommon();
		assertTrue(def1.getLevel()>= 1);
		assertTrue(def1.getMaxHealth() >= 10);
		assertTrue(def1.getAttackDamage() >= 5);
		assertTrue(def1.getHealAmount() >= 5);
		assertEquals(def1.getRarity(), "Common");
	}
	
	
	@Test
	public void createRareTest() {
		MonsterCreator monsterCreator = new MonsterCreator();
		Monster def2 = monsterCreator.createRare();
		assertTrue(def2.getLevel() >= 1);
		assertTrue(def2.getMaxHealth() >= 20);
		assertTrue(def2.getAttackDamage() >= 10);
		assertTrue(def2.getHealAmount() >= 10);
		assertEquals(def2.getRarity(), "Rare");
	}
	
	@Test
	public void createSuperEpicTest() {
		MonsterCreator monsterCreator = new MonsterCreator();
		Monster def3 = monsterCreator.createSuperEpic();
		assertTrue(def3.getLevel() >= 1);
		assertTrue(def3.getMaxHealth() >= 40);
		assertTrue(def3.getAttackDamage() >=20);
		assertTrue(def3.getHealAmount() >= 20);
		assertEquals(def3.getRarity(), "Super Epic");
	}

}
