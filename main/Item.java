/**
 * 
 */
package main;

/**
 * This class implements an Item which can be bought
 * from the shop by the player as it implements the
 * Purchasable interface. The Item can be stored by
 * the player and then used on one of the Monsters
 * in the player's squad to increase one of its stats.
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class Item implements Purchasable {

	private String name;
	private int purchasePrice;
	private int resellPrice;
	
	/**
	 * 
	 */
	public Item() {
		// TODO Auto-generated constructor stub
		name = "Pie";
	}

	@Override
	public int getPurchasePrice() {
		return purchasePrice;
	}

	@Override
	public int getResellPrice() {
		return resellPrice;
	}
	
	public String getName() {
		return name;
	}

}
