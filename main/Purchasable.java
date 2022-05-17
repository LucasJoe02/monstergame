/**
 * 
 */
package main;

/**
 * This Interface defines the functionality required
 * for an object to be able to be sold to the player
 * in the shop as well as for the player to be able
 * to sell the object back to the shop. Importantly
 * it requires the object to be able to show its
 * prices for purchasing and selling.
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public interface Purchasable {
	/** 
	 * Gets the price of purchasing this purchasable.
	 * @return the integer purchase price in gold.
	 */
	public int getPurchasePrice();
	/** 
	 * Gets the resell value of this purchasable.
	 * @return the integer resell value in gold.
	 */
	public int getResellPrice();
}
