package main;

public class ItemHeal implements Item {

	private String name;
	private int increaseAmount;
	private String desc;
	private int purchasePrice;
	private int resellPrice;
	
	public String getName() {
		return name;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getResellPrice() {
		return resellPrice;
	}
	
	public int getIncreaseAmount() {
		return increaseAmount;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void heal(Monster monster) {
		monster.heal();
		
	}
	
	
	
}
