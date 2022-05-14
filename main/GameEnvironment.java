/**
 * 
 */
package main;

/**
 * This class controls all of the objects and information
 * about the current game being played. 
 * @author Lucas Redding
 */
public class GameEnvironment {
	
	static final int EASY_START_GOLD = 20;
	static final int HARD_START_GOLD = 10;

	private Player player;
	private Shop shop;
	private Arena arena;
	private int day;
	private int maxDays;
	private int difficulty;
	
	/**
	 * 
	 */
	public GameEnvironment() {
		day = 1;
		shop = new Shop();
		arena = new Arena();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(String name, Monster startMonster) {
		player = new Player();
		player.setName(name);
		player.getSquad().addMonster(startMonster);
		if (difficulty == 1) {
			player.increaseGold(EASY_START_GOLD);
		}else {
			player.increaseGold(HARD_START_GOLD);
		}
	}
	
	public Shop getShop() {
		return shop;
	}
	
	public Arena getArena() {
		return arena;
	}
	
	public int getDay() {
		return day;
	}
	
	public void increaseDay() {
		day += 1;
	}
	
	public int getMaxDays() {
		return maxDays;
	}
	
	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

}
