package main.monster;

import java.util.Random;

/**
 * This class implements a Monster which can be purchased
 * by the player using the shop class adding the Monster 
 * to the player's squad. A Monster is also part of the
 * team of an enemy's squad which the player fights using
 * their squad of Monsters.
 * 
 * @author Lucas Redding
 * @author Celeste Turnock
 * @version 1.1, May 2022.
 */
public class Monster {
	
	/** 
	 * The default purchase price of any Monster of "Super Epic" rarity.
	 */
	static final int SUPER_EPIC_PURCHASE_PRICE = 100;
	/** 
	 * The default level up bonus of any Monster of "Super Epic" rarity.
	 */
	static final int SUPER_EPIC_LEVEL_UP_BONUS = 10;
	/** 
	 * The default purchase price of any Monster of "Rare" rarity.
	 */
	static final int RARE_PURCHASE_PRICE = 50;
	/** 
	 * The default level up bonus of any Monster of "Rare" rarity.
	 */
	static final int RARE_LEVEL_UP_BONUS = 5;
	/** 
	 * The default purchase price of any Monster of "Common" rarity.
	 */
	static final int COMMON_PURCHASE_PRICE = 20;
	/** 
	 * The default level up bonus of any Monster of "Common" rarity.
	 */
	static final int COMMON_LEVEL_UP_BONUS = 2;

	/** 
	 * The name of the Monster.
	 */
	private String name;
	/** 
	 * The level of the Monster.
	 */
	private int level;
	/** 
	 * The maximum health of the Monster.
	 */
	private int maxHealth;
	/** 
	 * The current health of the Monster.
	 */
	private int currentHealth;
	/** 
	 * The attack damage of the Monster.
	 */
	private int attackDamage;
	/** 
	 * The amount by which the Monster heals when healed.
	 */
	private int healAmount;
	/** 
	 * Whether or not the Monster is awake.
	 */
	private boolean isFainted;
	/** 
	 * The purchase price of the Monster.
	 */
	private int purchasePrice;
	/** 
	 * The gold gained by selling the Monster.
	 */
	private int resellPrice;
	/** 
	 * The rarity of the Monster.
	 */
	private String rarity;
	/** 
	 * The amount a random stat increases when the Monster levels up.
	 */
	private int levelUpBonus;
	/**
	 * A description of the monster
	 */
	private String desc;
	
	/**
	 * Creates a new Monster based on given parameters.
	 * Sets the variables of the Monster based on what is passed to constructor.
	 * Health is set to full and isFainted is set to false.
	 * The purchase price and level up bonus are set based on the rarity given.
	 * The resell price is set to half the purchase price.
	 * For every level in the amount of levels passed to the function the levelUp
	 * function is called to randomly upgrade one of the Monsters stats.
	 * 
	 * @param name the name of the Monster.
	 * @param level the level of the Monster.
	 * @param maxHealth the maximum health of the Monster.
	 * @param attackDamage the attack damage of the Monster.
	 * @param healAmount the amount by which the Monster heals when healed.
	 * @param rarity the rarity of the Monster.
	 */
	public Monster(String name, int level, int maxHealth, int attackDamage, int healAmount, String rarity) {
		this.name = name;
		this.level = level;
		this.maxHealth = maxHealth;
		this.attackDamage = attackDamage;
		this.healAmount = healAmount;
		this.rarity = rarity;
		
		this.currentHealth = this.maxHealth;
		this.isFainted = false;
		if (this.rarity == "Super Epic") {
			this.purchasePrice = SUPER_EPIC_PURCHASE_PRICE;
			this.levelUpBonus = SUPER_EPIC_LEVEL_UP_BONUS;
		}else if (this.rarity == "Rare") {
			this.purchasePrice = RARE_PURCHASE_PRICE;
			this.levelUpBonus = RARE_LEVEL_UP_BONUS;
		}else {
			this.purchasePrice = COMMON_PURCHASE_PRICE;
			this.levelUpBonus = COMMON_LEVEL_UP_BONUS;
		}
		this.resellPrice = this.purchasePrice/2;
		
		this.level = 1;
		for (int i = 1; i <= level; i++) {
			levelUp();
		}
	}
	
	/**
	 * Gets the current health of this Monster.
	 * @return this Monster's current health.
	 */
	public int getHealth() {
		return currentHealth;
	}
	
	/**
	 * Gets the name of this Monster.
	 * @return this Monster's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the maximum health of this Monster.
	 * @return this Monster's maximum health.
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * Gets the rarity of this Monster.
	 * @return this Monster's rarity.
	 */
	public String getRarity() {
		return rarity;
	}
	
	/**
	 * Gets the attack damage of this Monster.
	 * @return this Monster's attack damage.
	 */
	public int getAttackDamage() {
		return attackDamage;
	}
	
	/**
	 * Gets the description of this Monster.
	 * @return this Monster's description
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * Sets the name of this Monster.
	 * @param name the new name of this monster.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Increases the maximum health of this Monster by a given amount.
	 * @param amount the amount to increase the max health by.
	 */
	public void increaseMaxHealth(int amount) {
		maxHealth += amount;
		currentHealth += amount;
	}
	
	/**
	 * Increases the attack damage of this Monster by a given amount.
	 * @param amount the amount to increase the attack damage by.
	 */
	public void increaseAttackDamage(int amount) {
		attackDamage += amount;
	}
	
	/**
	 * Increases the heal amount of this Monster.
	 * @param amount the amount to increase the heal amount by.
	 */
	public void increaseHealAmount(int amount) {
		healAmount += amount;
	}
	
	/**
	 * Increases the level of this Monster by one.
	 * Randomly decides on which of the three upgradable
	 * stats to increase when leveling up and increases
	 * that stat by the level up bonus of this Monster.
	 */
	public void levelUp() {
		level += 1;
		
		Random r = new Random();
        int i = Math.abs(r.nextInt()%3);
        switch (i) {
            case 0:
                increaseMaxHealth(levelUpBonus);
                break;
            case 1:
                increaseAttackDamage(levelUpBonus);
                break;
            case 2:
                increaseHealAmount(levelUpBonus);
                break;
            default:
                break;
        }
	}
	
	/**
	 * Decreases this Monster's health by a given amount of damage.
	 * If this Monster's health ends up at zero or less the isFainted
	 * variable will become true to show this Monster is no longer
	 * conscious.
	 * @param damage the damage for the current health to be reduced by.
	 */
	public void takeDamage(int damage) {
		currentHealth -= damage;
		if (currentHealth <= 0) {
			currentHealth = 0;
			isFainted = true;
		}
	}
	/**
	 * Gets whether the monster has fainted or not.
	 * @return whether the monster has fainted or not.
	 */
	public boolean getIsFainted() {
		return isFainted;
	}
	
	/**
	 * Heals this Monster's current Health by its heal amount.
	 * Ensures that this Monster is no longer fainted.
	 * If this Monster is healed beyond its max health the
	 * current health is set to the max health.
	 */
	public void heal() {
		isFainted = false;
		currentHealth += healAmount;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}

	/**
	 * Gets the purchase price of this monster.
	 * @return the integer purchase price of the monster
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * Gets the sell price of this monster.
	 * @return the integer sell price of this monster
	 */
	public int getResellPrice() {
		return resellPrice;
	}
	
	/**
	 * Returns a string representation of this Monster.
	 * Displays all the important statistics of this Monster.
	 * @return a string representation of this Monster.
	 */
	@Override
	public String toString() {
		String faintString;
		if (isFainted) {
			faintString = "Fainted";
		}else {
			faintString = "Awake";
		}
		return "Name: "+name+
				"\nWakefullness: "+faintString+
				"\nRarity: "+rarity+
				"\nLevel: "+level+
				"\nHealth: "+currentHealth+"/"+maxHealth+
				"\nAttack: "+attackDamage+
				"\nHealing: "+healAmount+
				"\nSell Price: "+resellPrice;
	}

}
