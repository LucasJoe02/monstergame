/**
 * 
 */
package main;

/**
 * @author Lucas Redding
 *
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
