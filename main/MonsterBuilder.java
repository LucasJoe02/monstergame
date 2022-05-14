/**
 * 
 */
package main;

/**
 * @author Lucas Redding
 *
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
