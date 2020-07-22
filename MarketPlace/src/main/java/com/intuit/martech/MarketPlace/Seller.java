package com.intuit.martech.MarketPlace;

/**
 * @author vkhanna
 *
 */
public class Seller {

	private String id;
	private String name;

	/**
	 * Constructor.
	 * 
	 * @param id
	 * @param name
	 */
	public Seller(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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

}
