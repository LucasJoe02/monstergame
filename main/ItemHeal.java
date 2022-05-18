package main;

public class ItemHeal implements Item {

	private String name = "Healer!";
	private int increaseAmount;
	private String desc;
	private int purchasePrice;
	private int resellPrice;
	
	public String getName() {
		return name;
	}
	
	public int getPurchasePrice() {
		purchasePrice = 5;
		return purchasePrice;
	}
	
	public int getResellPrice() {
		resellPrice = 3;
		return resellPrice;
	}
	
	public int getIncreaseAmount() {
		return increaseAmount;
	}
	
	public String getDesc() {
		desc = "The "+name+" increases your monster's current health by their current heal amount!";
		return desc;
	}
	
	public void heal(Monster monster) {
		monster.heal();
		
	}
	
	
	
}
