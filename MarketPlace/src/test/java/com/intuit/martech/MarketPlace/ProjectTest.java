/**
 * 
 */
package com.intuit.martech.MarketPlace;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

/**
 * @author vkhanna
 *
 */
public class ProjectTest {

	private Gson gson;
	private static final String expected = "{\"id\":1,\"description\":\"Build a MarketPlace for self-employed.\",\"maxBudget\":10000.0,\"bidsAccepted\":{\"year\":2020,\"month\":8,\"dayOfMonth\":30,\"hourOfDay\":23,\"minute\":59,\"second\":59},\"bids\":[{\"fixedBidAmount\":9500.0},{\"fixedBidAmount\":9250.0}]}";
	
	@Before
	public void setupGson() {
		gson = new Gson();
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public void testToString() {
		Project project = new Project(1, "Build a MarketPlace for self-employed.", 10000.00f, new GregorianCalendar(2020,8,30,23,59,59));
		Bid bid = new Bid(9500.00f);
		project.addBid(bid);
		bid = new Bid(9250.00f);
		project.addBid(bid);
		
		System.out.println(gson.toJson(project));
		assertEquals(expected, gson.toJson(project));
	}
}
