/**
 * 
 */
package com.intuit.martech.MarketPlace;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

/**
 * @author vkhanna
 *
 */
public class BuyerTest {

	private Gson gson;
	private static final String expected = "{\"id\":20,\"name\":\"Vivek Khanna\",\"bids\":[{\"fixedBidAmount\":9500.0},{\"fixedBidAmount\":9250.0}]}";
	
	@Before
	public void setupGson() {
		gson = new Gson();
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public void testToString() {
		Buyer buyer = new Buyer(20, "Vivek Khanna");
		Bid bid = new Bid(9500.00f);
		buyer.addBid(bid);
		bid = new Bid(9250.00f);
		buyer.addBid(bid);
		
		System.out.println(gson.toJson(buyer));
		assertEquals(expected, gson.toJson(buyer));
	}

}
