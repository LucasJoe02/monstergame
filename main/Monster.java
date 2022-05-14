/**
 * 
 */
package main;

import java.util.Random;

/**
 * @author Lucas Redding
 *
 */
public class Monster implements Purchasable {
	
	static final int SUPER_EPIC_PURCHASE_PRICE = 100;
	static final int SUPER_EPIC_LEVEL_UP_BONUS = 10;
	static final int RARE_PURCHASE_PRICE = 50;
	static final int RARE_LEVEL_UP_BONUS = 5;
	static final int COMMON_PURCHASE_PRICE = 20;
	static final int COMMON_LEVEL_UP_BONUS = 2;

	private String name;
	private int level;
	private int maxHealth;
	private int currentHealth;
	private int attackDamage;
	private int healAmount;
	private boolean isFainted;
	private int purchasePrice;
	private int resellPrice;
	private String rarity;
	private int levelUpBonus;
	
	/**
	 * 
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
	
	public int getHealth() {
		return currentHealth;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public int getAttackDamage() {
		return attackDamage;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void increaseMaxHealth(int amount) {
		maxHealth += amount;
		currentHealth += amount;
	}
	
	public void increaseAttackDamage(int amount) {
		attackDamage += amount;
	}
	
	public void increaseHealAmount(int amount) {
		healAmount += amount;
	}
	
	public void levelUp() {
		level += 1;
		
		Random r = new Random();
        int i = r.nextInt()%3;
        switch (i) {
            case 0:
                increaseMaxHealth(levelUpBonus);
            case 1:
                increaseAttackDamage(levelUpBonus);
            case 2:
                increaseHealAmount(levelUpBonus);
            default:
                break;
        }
	}
	
	public void takeDamage(int damage) {
		currentHealth -= damage;
		if (currentHealth <= 0) {
			currentHealth = 0;
			isFainted = true;
		}
	}
	
	public void heal(int healAmount) {
		isFainted = false;
		currentHealth += healAmount;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}

	@Override
	public int getPurchasePrice() {
		return purchasePrice;
	}

	@Override
	public int getResellPrice() {
		return resellPrice;
	}
	
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
