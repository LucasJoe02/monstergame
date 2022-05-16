/**
 * 
 */
package main;

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
	MonsterBuilder withName(String name);
	MonsterBuilder withLevel(int level);
	MonsterBuilder withMaxHealth(int maxHealth);
	MonsterBuilder withAttackDamage(int attackDamage);
	MonsterBuilder withHealAmount(int healAmount);
	MonsterBuilder withRarity(String rarity);
    Monster build();
}
