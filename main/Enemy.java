package main;

import java.util.Random;

/**
 * This class implements an Enemy which stores information
 * that is needed to fight the player in battle.
 * The enemy has a squad of Monsters and a set amount of gold
 * and points that can be obtained by defeating them.
 * 
 * @author Celeste Turnock
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */

public class Enemy {

	/**
	 * A GameEnvironment to link back to current GameEnvironment being used.
	 */
	private GameEnvironment game;
	/**
	 * A monster creator to generate new monsters.
	 */
	private MonsterCreator monsterCreator;
	/**
	 * The name of this enemy.
	 */
	private String name;
	/**
	 * The amount of gold that can be obtained by defeating this enemy.
	 */
	private int gold;
	/**
	 * The amount of points that can be obtained by defeating this enemy.
	 */
	private int points;
	/**
	 * The squad of Monsters associated with this enemy.
	 */
	private Squad squad;
	/** 
	 * A list of potential names for this enemy.
	 */
	private String[] names = {"Jake", "Nathan", "Bobby Brown", "Mr Purple", "Alvin", "Sweetpea" };
	/**
	 * The random number generator used to randomly generate specific variables in creating unique enemies.
	 */
	Random rng;
	
	/**
	 * Creates an Enemy instance and generates the name, gold, points and squad.
	 * Also calls current GameEnvironment and initializes random number generator.
	 * @param game the current GameEnvironment.
	 */
	public Enemy(GameEnvironment game) {
		this.game = game;
		name = "";
		gold = 0;
		points = 0;
		squad = new Squad();
		rng = new Random();
		setName();
		setGold();
		setPoints();
		setSquad();
	}
	/**
	 * Generates and then assigns a random name for the enemy from a list of potential names.
	 */
	public void setName() {
		name = names[rng.nextInt(names.length)];
	}
	
	/**
	 * Gets the name of the enemy.
	 * @return the name of the enemy.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Generates and then assigns an appropriate amount of gold based on game difficulty and current day.
	 */
	public void setGold() {
		if (game.getDifficulty() == 1) {
			gold = game.getDay() * 2;
		} else {
			gold = game.getDay();
		}
	}
	
	/**
	 * Gets the amount of gold the enemy has.
	 * @return the amount of gold the enemy has.
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * Generates and then assigns an appropriate amount of points based on game difficulty and current day.
	 */
	public void setPoints() {
		if (game.getDifficulty()==1) {
			points = game.getDay() *6;
		} else {
			points = game.getDay() * 10;
		}
	}
	
	/**
	 * Gets the amount of points the enemy is worth.
	 * @return the amount of points the enemy is worth.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Generates and then assigns an appropriate squad of monsters for the enemy based on game difficulty and current day.
	 */
	public void setSquad() {
		int j = 0;
		if (game.getDifficulty() ==1 && game.getDay() <=5) {
			j=0;	
		}else if (game.getDifficulty() ==2 && game.getDay() <= 5) {
			j=1;
		}else if (game.getDifficulty() ==1 && game.getDay() <= 10) {
			j=2;
		}else if (game.getDifficulty() ==2 && game.getDay() <= 10) {
			j=3;
		}else if (game.getDifficulty() ==1 && game.getDay() > 10) {
			j=4;		
		}else {
			j=5;
		}
		
		switch (j) {
			case 0:
				int num0 = rng.nextInt(1,2);
				for (int i = 0; i <= num0; i++) {
				squad.addMonster(monsterCreator.createCommon());}
				break;
			case 1:
				int num1 = rng.nextInt(1,4);
				for (int i = 0; i <= num1; i++) {
					squad.addMonster(monsterCreator.createCommon());}
				break;
			case 2:
				int num2 = rng.nextInt(1,2);
				for (int i = 0; i <= num2; i++) {
					squad.addMonster(monsterCreator.createCommon());}
				for (int i = 0; i <= num2; i++) {
					squad.addMonster(monsterCreator.createRare());
				}
				break;
			case 3:
				int num3 = rng.nextInt(1,3);
				for (int i = 0; i <= num3; i++) {
					squad.addMonster(monsterCreator.createCommon());}
				for (int i = 1; i <= num3; i++) {
					squad.addMonster(monsterCreator.createRare());
				}
				break;
			case 4:
				int num4 = rng.nextInt(1,3);
				for (int i = 0; i <= num4; i++) {
					squad.addMonster(monsterCreator.createCommon());}
				for (int i = 0; i <= num4; i++) {
					squad.addMonster(monsterCreator.createRare());}
				break;
			case 5:
				int num5 = rng.nextInt(1,3);
				for (int i = 0; i <= num5; i++) {
					squad.addMonster(monsterCreator.createCommon());}
				for (int i = 0; i <= num5; i++) {
					squad.addMonster(monsterCreator.createRare());}
				squad.addMonster(monsterCreator.createSuperEpic());
				break;
			default:
				break;
		}
	}
	
	/**
	 * Gets the squad of this enemy.
	 * @return the squad of this enemy.
	 */
	public Squad getSquad() {
		return squad;
	}
}
