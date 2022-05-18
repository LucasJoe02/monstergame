/**
 * 
 */
package main;

/**
 * This class controls all of the objects and information
 * about the current game being played. Including the
 * current user player, the game shop, arena and keeps
 * track of the day and difficulty. It provides the
 * functionality for the user to utilize the parts of
 * the game and progress.
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class GameEnvironment {
	
	/** 
	 * Gold that the user begins with when playing on easy mode.
	 */
	static final int EASY_START_GOLD = 20;
	/** 
	 * Gold that the user begins with when playing on hard mode.
	 */
	static final int HARD_START_GOLD = 10;
	
	/** 
	 * User player associated with this game environment.
	 */
	private Player player;
	/** 
	 * Shop associated with this game environment.
	 */
	private Shop shop;
	/** 
	 * Arena associated with this game environment.
	 */
	private Arena arena;
	/** 
	 * Current day of this game.
	 */
	private int day;
	/** 
	 * Maximum amount of days the game can run for.
	 */
	private int maxDays;
	/** 
	 * The difficulty of this game.
	 */
	private int difficulty;
	
	/**
	 * Constructor that initializes the day to 1 and creates the shop and arena for the game.
	 */
	public GameEnvironment() {
		day = 1;
		shop = new Shop();
		arena = new Arena();
	}
	
	/** 
	 * Gets the player associated with this game environment.
	 * @return user player of this game environment.
	 */
	public Player getPlayer() {
		return player;
	}
	
	/** 
	 * Sets the player associated with this game environment.
	 * creates the player and gives the player a name and starter monster based on parameters.
	 * Sets the gold of the player based on the difficulty of the game.
	 * @param name the name of the player to be created.
	 * @param startMonster the starter monster to be added to the player's squad.
	 */
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
	
	/** 
	 * Gets the shop associated with this game.
	 * @return the shop associated with this game.
	 */
	public Shop getShop() {
		return shop;
	}
	
	/** 
	 * Gets the arena associated with this game.
	 * @return the arena associated with this game.
	 */
	public Arena getArena() {
		return arena;
	}
	
	/** 
	 * Gets the day of this game.
	 * @return the day of this game.
	 */
	public int getDay() {
		return day;
	}
	
	/** 
	 * Increases the day of the game by one. 
	 */
	public void increaseDay() {
		day += 1;
	}
	
	/** 
	 * Gets the maximum amount of days this game can run for.
	 * @return the maximum days of this game.
	 */
	public int getMaxDays() {
		return maxDays;
	}
	
	/** 
	 * Sets the maximum amount of days this game can run for.
	 * @param maxDays the amount of days this game can run for.
	 */
	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}
	
	/** 
	 * Gets the difficulty of this game.
	 * 1 is easy and 2 is hard.
	 * @return the integer difficulty of this game.
	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	/** 
	 * Sets the difficulty of this game.
	 * 1 is easy and 2 is hard.
	 * @param difficulty the integer difficulty to set for this game.
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

}
