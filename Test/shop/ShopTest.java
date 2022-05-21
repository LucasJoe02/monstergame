package Test.shop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.arena.Enemy;
import main.environment.GameEnvironment;
import main.item.Item;
import main.item.ItemHeal;
import main.monster.Monster;
import main.monster.MonsterCreator;
import main.shop.Shop;

class ShopTest {
	
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
	public void refreshStockTest() {
		GameEnvironment game = initial();
		Shop testShop = new Shop(game);
		assertEquals(3, testShop.getMonsters().size());
		assertEquals(4, testShop.getItems().size());
		assertEquals(Monster.class, testShop.getMonsters().get(0).getClass());
		assertTrue(testShop.getItems().get(0) instanceof Item);
	}
	
	@Test
	public void purchaseMonsterTest() {
		GameEnvironment game = initial();
		Shop testShop = new Shop(game);
		int initGold = game.getPlayer().getGold();
		int initSquad = game.getPlayer().getSquad().getMonsters().size();
		testShop.purchaseMonster(0);
		int postGold = game.getPlayer().getGold();
		int postSquad = game.getPlayer().getSquad().getMonsters().size();
		assertTrue(initGold > postGold);
		assertTrue(initSquad < postSquad);
	}
	
	@Test
	public void purchaseItemTest() {
		GameEnvironment game = initial();
		Shop testShop = new Shop(game);
		int initGold = game.getPlayer().getGold();
		int initItems = game.getPlayer().getItems().size();
		testShop.purchaseItem(0);
		int postGold = game.getPlayer().getGold();
		int postItems = game.getPlayer().getItems().size();
		assertTrue(initGold > postGold);
		assertTrue(initItems < postItems);
	}
	
	@Test
	public void sellMonsterTest() {
		GameEnvironment game = initial();
		Shop testShop = new Shop(game);
		MonsterCreator monsterCreator = new MonsterCreator();
		Monster monster = monsterCreator.createRandom();
		game.getPlayer().getSquad().addMonster(monster);
		int initGold = game.getPlayer().getGold();
		int initSquad = game.getPlayer().getSquad().getMonsters().size();
		testShop.sellMonster(0);
		int postGold = game.getPlayer().getGold();
		int postSquad = game.getPlayer().getSquad().getMonsters().size();
		assertTrue(initGold < postGold);
		assertTrue(initSquad > postSquad);
	}
	
	@Test
	public void sellItemTest() {
		GameEnvironment game = initial();
		Shop testShop = new Shop(game);
		ItemHeal item = new ItemHeal();
		game.getPlayer().addItem(item);
		int initGold = game.getPlayer().getGold();
		int initItems = game.getPlayer().getItems().size();
		testShop.sellItem(0);
		int postGold = game.getPlayer().getGold();
		int postItems = game.getPlayer().getItems().size();
		assertTrue(initGold < postGold);
		assertTrue(initItems > postItems);
	}

}
