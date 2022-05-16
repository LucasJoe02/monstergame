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
	public int getPurchasePrice();
	public int getResellPrice();
}
