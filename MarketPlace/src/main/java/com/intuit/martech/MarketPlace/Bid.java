/**
 * 
 */
package com.intuit.martech.MarketPlace;

/**
 * @author vkhanna
 *
 */
public class Bid {

	private float fixedBidAmount;
	
	/**
	 * 
	 */
	public Bid() {
		
	}
	
	/**
	 * 
	 * @param fixedBidAmount
	 */
	public Bid(float fixedBidAmount) {
		this.fixedBidAmount = fixedBidAmount;
	}

	/**
	 * @return the fixedBidAmount
	 */
	public float getFixedBidAmount() {
		return fixedBidAmount;
	}

	/**
	 * @param fixedBidAmount the fixedBidAmount to set
	 */
	public void setFixedBidAmount(float fixedBidAmount) {
		this.fixedBidAmount = fixedBidAmount;
	}
}
