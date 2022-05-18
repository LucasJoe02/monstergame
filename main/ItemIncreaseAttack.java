package main;

public class ItemIncreaseAttack implements Item{

	private String name = "Gun!";
	private int increaseAmount;
	private String desc;
	private int purchasePrice;
	private int resellPrice;
	
	public String getName() {
		return name;
	}
	
	public int getIncreaseAmount() {
		return increaseAmount;
	}
	
	public String getDesc() {
		desc = name + " increases your monster's attack damage, making it possible to cause more damage to your oponent!";
		return desc;
	}
	
	public int getPurchasePrice() {
		purchasePrice = 10;
		return purchasePrice;
	}
	
	public int getResellPrice() {
		resellPrice = 5;
		return resellPrice;
	}
	
	public void increaseAttackDamage(Monster monster) {
		monster.increaseAttackDamage(increaseAmount);
		
	}
}
