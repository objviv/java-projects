/**
 * 
 */
package com.intuit.martech.MarketPlace;

/**
 * @author vkhanna
 *
 */
public class Bid implements Comparable<Bid> {

	private float fixedBidAmount;
	private int projectId;
	
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
	 * 
	 * @param fixedBidAmount
	 * @param projectId
	 */
	public Bid(float fixedBidAmount, int projectId) {
		this.fixedBidAmount = fixedBidAmount;
		this.projectId = projectId;
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

	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public int compareTo(Bid o) {
		if (o != null) {
			Float f1 = new Float(this.getFixedBidAmount());
			Float f2 = new Float(o.getFixedBidAmount());
			return f1.compareTo(f2);
		}
		return 0;
	}
}
