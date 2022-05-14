/**
 * 
 */
package main;

import java.util.Random;

/**
 * @author Lucas Redding
 *
 */
public class MonsterCreator {
	
	private MonsterBuilder monsterBuilder;
	private String[] namePrefixes = {"Lava","Rock","Fire","Water","Air","Flame"};
	private String[] nameSuffixes = {"Kitty","Puppy","Melon","Leaf","Dragon","Bird"};
	Random rng;

	/**
	 * 
	 */
	public MonsterCreator() {
		monsterBuilder = new MonsterBuilderImpl();
		rng = new Random();
	}
	
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
	
//	public static void main(String[] args) {
//		MonsterCreator monsterCreator = new MonsterCreator();
//		System.out.println(monsterCreator.createCommon());
//
//		System.out.println(monsterCreator.createRare());
//
//		System.out.println(monsterCreator.createSuperEpic());
//
//		System.out.println(monsterCreator.createRandom());
//	}

}
