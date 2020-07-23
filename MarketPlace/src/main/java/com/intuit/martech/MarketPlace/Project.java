/**
 * 
 */
package com.intuit.martech.MarketPlace;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author vkhanna
 *
 */
public class Project {
	
	private int id;
	private String description;
	private float maxBudget;
	private String currency;
	@JsonSerialize(using = CalendarSerializer.class)
	@JsonDeserialize(using = CalendarDeserializer.class)
	private Calendar bidsAccepted;
	private List<Bid> bids;
	
	/**
	 * 
	 */
	public Project() {
		
	}
	
	/**
	 * 
	 * @param id
	 * @param descr
	 * @param maxBudget
	 * @param bidsAccepted
	 */
	public Project(int id, String descr, float maxBudget, Calendar bidsAccepted) {
		this.id = id;
		this.description = descr;
		this.maxBudget = maxBudget;
		this.bidsAccepted = bidsAccepted;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the maxBudget
	 */
	public float getMaxBudget() {
		return maxBudget;
	}
	/**
	 * @param maxBudget the maxBudget to set
	 */
	public void setMaxBudget(float maxBudget) {
		this.maxBudget = maxBudget;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the bidsAccepted
	 */
	public Calendar getBidsAccepted() {
		return bidsAccepted;
	}
	/**
	 * @param bidsAccepted the bidsAccepted to set
	 */
	public void setBidsAccepted(Calendar bidsAccepted) {
		this.bidsAccepted = bidsAccepted;
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