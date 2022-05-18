package main;

public class ItemIncMaxHP implements Item{

	private String name = "Super Health!";
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
		desc = name + " increases your monster's current total health amount!";
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
	
	public void increaseMaxHealth(Monster monster) {
		monster.increaseMaxHealth(increaseAmount);
	}
	
}
