/**
 * 
 */
package main;

/**
 * This class implements the MonsterBuilder interface
 * and is responsible for adding variables defined by
 * MonsterCreator to the Monster currently being built
 * and then building the Monster which can then be used
 * throughout the game.
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class MonsterBuilderImpl implements MonsterBuilder {

	private String name;
	private int level;
	private int maxHealth;
	private int attackDamage;
	private int healAmount;
	private String rarity;
	Monster monster;
	
	/**
	 * 
	 */
	public MonsterBuilderImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MonsterBuilder withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public MonsterBuilder withLevel(int level) {
		this.level = level;
		return this;
	}

	@Override
	public MonsterBuilder withMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
		return this;
	}

	@Override
	public MonsterBuilder withAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
		return this;
	}

	@Override
	public MonsterBuilder withHealAmount(int healAmount) {
		this.healAmount = healAmount;
		return this;
	}

	@Override
	public MonsterBuilder withRarity(String rarity) {
		this.rarity = rarity;
		return this;
	}

	@Override
	public Monster build() {
		monster = new Monster(name, level, maxHealth, attackDamage, healAmount, rarity);
		return monster;
	}

}
