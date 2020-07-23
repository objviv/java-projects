/**
 * 
 */
package com.intuit.martech.MarketPlace;

import java.util.Calendar;

/**
 * @author vkhanna
 *
 */
public class Project {
	
	private String description;
	private float maxBudget;
	private String currency;
	private Calendar bidsAccepted;
	
	/**
	 * 
	 */
	public Project() {
		
	}
	
	/**
	 * 
	 * @param descr
	 * @param maxBudget
	 * @param bidsAccepted
	 */
	public Project(String descr, float maxBudget, Calendar bidsAccepted) {
		this.description = descr;
		this.maxBudget = maxBudget;
		this.bidsAccepted = bidsAccepted;
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

}
