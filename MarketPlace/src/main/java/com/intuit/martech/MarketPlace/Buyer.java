/**
 * 
 */
package com.intuit.martech.MarketPlace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vkhanna
 *
 */
public class Buyer {
	
	private int id;
	private String name;
	private List<Bid> bids;
	
	public Buyer() {}
	
	public Buyer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bids
	 */
	public List<Bid> getBids() {
		return bids;
	}

	/**
	 * @param bids the bids to set
	 */
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	
	/**
	 * 
	 * @param bid
	 */
	public void addBid(Bid bid) {
		if (null == this.bids) {
			this.bids = new ArrayList<Bid>();
		}
		this.bids.add(bid);
	}
}
