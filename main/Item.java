package main;

public interface Item {

	public int getPurchasePrice();
	public int getResellPrice();
	public String getName();
	public String getDesc();
	public void useItem(Monster monster);
}
