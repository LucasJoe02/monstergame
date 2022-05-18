package main;

public class ItemIncHealSpd implements Item {

	private String name = "Bounce-Back!";
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
		desc = name + " increases your monster's current heal amount, making it possible to regain more health overnight!";
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
	
	public void increaseHealAmount(Monster monster) {
		monster.increaseHealAmount(increaseAmount);
	}
}
