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
public class BidTest {

	private Gson gson;
	private static final String expected = "{\"fixedBidAmount\":10000.0}";
	
	@Before
	public void setupGson() {
		gson = new Gson();
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public void testToString() {
		Bid bid = new Bid(10000.00f);
		
		System.out.println(gson.toJson(bid));
		assertEquals(expected, gson.toJson(bid));
	}

}
