package main;

import java.util.Random;

public class Enemy {

	private GameEnvironment game;
	private MonsterCreator monsterCreator;
	private String name;
	private int gold;
	private int points;
	private Squad squad;
	private String[] names = {"Jake", "Nathan", "Bobby Brown", "Mr Purple", "Alvin", "Sweetpea"};
	Random rng;
	
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
	
	public void setName() {
		name = names[rng.nextInt(names.length)];
	}
	
	public String getName() {
		return name;
	}
	
	public void setGold() {
		if (game.getDifficulty() == 1) {
			gold = game.getDay() * 2;
		} else {
			gold = game.getDay();
		}
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setPoints() {
		if (game.getDifficulty()==1) {
			points = game.getDay() *6;
		} else {
			points = game.getDay() * 10;
		}
	}
	
	public int getPoints() {
		return points;
	}
	
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
	
	public Squad getSquad() {
		return squad;
	}
}
