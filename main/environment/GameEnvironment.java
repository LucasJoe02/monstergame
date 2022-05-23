package main.environment;

import java.util.ArrayList;
import java.util.Random;

import main.arena.Arena;
import main.monster.Monster;
import main.monster.MonsterCreator;
import main.player.Player;
import main.shop.Shop;

/**
 * This class controls all of the objects and information
 * about the current game being played. Including the
 * current user player, the game shop, arena and keeps
 * track of the day and difficulty. It provides the
 * functionality for the user to utilize the parts of
 * the game and progress.
 * 
 * @author Lucas Redding
 * @author Celeste Turnock
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
	 * Gold given to the player each night;
	 */
	static final int NIGHT_COINS_AMOUNT = 10;

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
	 * The random number generator used to randomly generate random events.
	 */
	private Random rng;
	/**
	 * The monster creator to create monsters.
	 */
	private MonsterCreator monsterCreator;
	
	/**
	 * Constructor that initializes the day to 1 and creates the shop and monster creator for the game.
	 */
	public GameEnvironment() {
		day = 1;
		shop = new Shop(this);
		monsterCreator = new MonsterCreator();
		rng = new Random();
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
	 * Sets the current day.
	 * @param day the integer day to change the current day to.
	 */
	public void setDay(int day) {
		this.day = day;
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
	 * after the difficulty is set the arena is updated to reflect the difficulty.
	 * @param difficulty the integer difficulty to set for this game.
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
		arena = new Arena(this);
	}
	
	/**
	 * Uses the player's item at a given index on a player's monster at a given index.
	 * @param itemIndex the integer index of the item in player's inventory
	 * @param monsterIndex the integer index of the monster in the player's squad
	 */
	public void useItemOnMonster(int itemIndex, int monsterIndex){
		player.getItems().get(itemIndex).useItem(player.getSquad().getMonsters().get(monsterIndex));
		player.getItems().remove(itemIndex);
	}
	
	/**
	 * Increases the day by one, refreshes the shop and arena, heals the player's monsters and implements random night events.
	 * The player receives an amount of coins overnight based on the nightCoinsAmount.
	 * There is a random chance that a monster in the player's squad will level up.
	 * There is a low chance a fainted monster will run away during the night if the player has more than one monster.
	 * There is a low chance a new monster will join the player's squad if the squad is not yet full.
	 * All night events are added to a string and returned so the UI can display the events to the user.
	 * @return the String representation of the night's random events
	 */
	public String sleep() {
		increaseDay();
		player.increaseGold(NIGHT_COINS_AMOUNT);
		shop.refreshStock();
		arena.refreshOpponents();
		player.getSquad().healMonsters();
		String nightEvents = "";
		int rand = rng.nextInt(100);
		ArrayList<Monster> monsters =  player.getSquad().getMonsters();
		if (rand < 50) {
			Monster lvlUpMonst = monsters.get(Math.abs(rng.nextInt()%monsters.size()));
			lvlUpMonst.levelUp();
			nightEvents += lvlUpMonst.getName()+" levelled up! ";
		}
		rand = rng.nextInt(100);
		if (rand < 10) {
			Monster leaveMonst = monsters.get(Math.abs(rng.nextInt()%monsters.size()));
			if (leaveMonst.getIsFainted()==true && monsters.size() > 1) {
				nightEvents += leaveMonst.getName()+" ran away! ";
				monsters.remove(leaveMonst);
			}
		}
		rand = rng.nextInt(100);
		if (rand < 10) {
			if (rng.nextInt()%5>monsters.size() && monsters.size()<4) {
				Monster newMonst = monsterCreator.createRandom();
				monsters.add(newMonst);
				nightEvents += "Monster "+newMonst.getName()+" joined overnight! ";
			}
		}
		return nightEvents;
	}

}
