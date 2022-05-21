package main.monster;

/**
 * This interface defines the functionality required
 * for the Monster builder pattern to create a usable
 * instance of the monster class for the user player
 * and enemy players.
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public interface MonsterBuilder {
	/**
	 * Gives the monster being built by the builder pattern a name.
	 * @param name the name of the monster being built.
	 * @return the instance of the builder describing the Monster being built.
	 */
	MonsterBuilder withName(String name);
	/**
	 * Gives the monster being built by the builder pattern a level.
	 * @param level the level of the monster being built.
	 * @return the instance of the builder describing the Monster being built.
	 */
	MonsterBuilder withLevel(int level);
	/**
	 * Gives the monster being built by the builder pattern a maximum health.
	 * @param maxHealth the maximum health of the monster being built.
	 * @return the instance of the builder describing the Monster being built.
	 */
	MonsterBuilder withMaxHealth(int maxHealth);
	/**
	 * Gives the monster being built by the builder pattern an attack damage.
	 * @param attackDamage the attack damage of the monster being built.
	 * @return the instance of the builder describing the Monster being built.
	 */
	MonsterBuilder withAttackDamage(int attackDamage);
	/**
	 * Gives the monster being built by the builder pattern a healing amount.
	 * @param healAmount the healing amount of the monster being built.
	 * @return the instance of the builder describing the Monster being built.
	 */
	MonsterBuilder withHealAmount(int healAmount);
	/**
	 * Gives the monster being built by the builder pattern a rarity.
	 * @param rarity the rarity of the monster being built.
	 * @return the instance of the builder describing the Monster being built.
	 */
	MonsterBuilder withRarity(String rarity);
	/**
	 * Builds the Monster being built by the Monster builder pattern.
	 * @return the Monster described by the Monster builder pattern.
	 */
    Monster build();
}
