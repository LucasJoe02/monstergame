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
	
	public void setPlayer() {
		player = new Player();
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
