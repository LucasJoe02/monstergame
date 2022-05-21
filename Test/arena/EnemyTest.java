package Test.arena;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.monster.Monster;

class EnemyTest {

	public GameEnvironment initial() {
		GameEnvironment game = new GameEnvironment();
		Monster def = new Monster("Jane", 1, 20, 10, 5, "Common");
		game.setPlayer("John Doe", def);
		game.setDifficulty(1);
		game.setMaxDays(5);
		return game;
	}	
	
	//Enemy comprised of getters and setters
	

}
