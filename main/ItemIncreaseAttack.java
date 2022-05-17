package main;

public class ItemIncreaseAttack implements Item, Purchasable{

	private String name;
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
		return desc;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getResellPrice() {
		return resellPrice;
	}
	
	public void increaseAttackDamage(Monster monster) {
		monster.increaseAttackDamage(increaseAmount);
		
	}
}
