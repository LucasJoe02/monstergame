/**
 * 
 */
package main;

import java.util.Random;

/**
 * This class is used by other classes as a part of the
 * builder design pattern for making new Monsters.
 * The class provides the functionality to build a
 * randomised Monster of either a specific rarity or
 * also a random rarity. 
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class MonsterCreator {
	
	/** 
	 * An instance of the MonsterBuilder used to build the Monster being described by the this MonsterCreator.
	 */
	private MonsterBuilder monsterBuilder;
	/** 
	 * The list of possible name prefixes for a Monster being built to have by default.
	 */
	private String[] namePrefixes = {"Lava","Rock","Fire","Water","Air","Flame"};
	/** 
	 * The list of possible name suffixes for a Monster being built to have by default.
	 */
	private String[] nameSuffixes = {"Kitty","Puppy","Melon","Leaf","Dragon","Bird"};
	/** 
	 * The random number generator used to randomly generate a Monster's stats.
	 */
	Random rng;

	/**
	 * Creates a MonsterCreator instance and initializes the MonsterBuilder and random number generator.
	 */
	public MonsterCreator() {
		monsterBuilder = new MonsterBuilderImpl();
		rng = new Random();
	}
	
	
	/** 
	 * Creates a Monster with a random rarity.
	 * Generates a random integer from 0 to 100.
	 * If the integer is below 70 a common Monster is generated, below 90 a Rare is generated.
	 * Otherwise a Super Epic Monster is generated.
	 * @returns the random Monster that was generated.
	 */
	public Monster createRandom() {
		int rand = rng.nextInt(101);
		Monster monster;
		if (rand < 70) {
			monster = createCommon();
		}else if (rand < 90) {
			monster = createRare();
		}else {
			monster = createSuperEpic();
		}
		return monster;
	}
	
	/** 
	 * Creates a Monster with common rarity.
	 * The name of the monster is a combination of a random name prefix and a random name suffix.
	 * The starting level of the monster is a random integer from 1 to 4.
	 * The other stats are random integers with specific constraints for this particular rarity of Monster.
	 * @return a common Monster.
	 */
	public Monster createCommon() {
		Monster monster = monsterBuilder
				.withName(namePrefixes[rng.nextInt(namePrefixes.length)]+" "+nameSuffixes[rng.nextInt(nameSuffixes.length)])
				.withLevel(rng.nextInt(1,5))
				.withMaxHealth(rng.nextInt(10,30))
				.withAttackDamage(rng.nextInt(5,10))
				.withHealAmount(rng.nextInt(5,10))
				.withRarity("Common")
				.build();
		return monster;
	}
	
	/** 
	 * Creates a Monster with rare rarity.
	 * The name of the monster is a combination of a random name prefix and a random name suffix.
	 * The starting level of the monster is a random integer from 1 to 4.
	 * The other stats are random integers with specific constraints for this particular rarity of Monster.
	 * @return a rare Monster.
	 */
	public Monster createRare() {
		Monster monster = monsterBuilder
				.withName(namePrefixes[rng.nextInt(namePrefixes.length)]+" "+nameSuffixes[rng.nextInt(nameSuffixes.length)])
				.withLevel(rng.nextInt(1,5))
				.withMaxHealth(rng.nextInt(20,40))
				.withAttackDamage(rng.nextInt(10,15))
				.withHealAmount(rng.nextInt(10,15))
				.withRarity("Rare")
				.build();
		return monster;
	}
	
	/** 
	 * Creates a Monster with super epic rarity.
	 * The name of the monster is a combination of a random name prefix and a random name suffix.
	 * The starting level of the monster is a random integer from 1 to 4.
	 * The other stats are random integers with specific constraints for this particular rarity of Monster.
	 * @return a super epic Monster.
	 */
	public Monster createSuperEpic() {
		Monster monster = monsterBuilder
				.withName(namePrefixes[rng.nextInt(namePrefixes.length)]+" "+nameSuffixes[rng.nextInt(nameSuffixes.length)])
				.withLevel(rng.nextInt(1,5))
				.withMaxHealth(rng.nextInt(40,60))
				.withAttackDamage(rng.nextInt(20,30))
				.withHealAmount(rng.nextInt(20,30))
				.withRarity("Super Epic")
				.build();
		return monster;
	}
}
