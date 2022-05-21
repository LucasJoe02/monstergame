package Test.monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.monster.Monster;

class SquadTest {

	public GameEnvironment initial() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		return game;
		
	}
	
	@Test
	public void healMonstersTest() {
		GameEnvironment game =initial();
		game.getPlayer().getSquad().getMonsters().get(0).takeDamage(12);
		int initHP = game.getPlayer().getSquad().getMonsters().get(0).getHealth();
		game.getPlayer().getSquad().healMonsters();
		int postHP =  game.getPlayer().getSquad().getMonsters().get(0).getHealth();
		assertTrue(initHP < postHP);
	}

}
