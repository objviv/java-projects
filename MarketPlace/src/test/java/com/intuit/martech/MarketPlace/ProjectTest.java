/**
 * 
 */
package com.intuit.martech.MarketPlace;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author vkhanna
 *
 */
public class ProjectTest {

	private Gson gson;
	private static final String expected = "{\"id\":1,\"description\":\"Build a MarketPlace for self-employed.\",\"maxBudget\":10000.0,\"bidsAccepted\":\"2020-09-30T23:59:59.000-0700\",\"bids\":[{\"fixedBidAmount\":9500.0},{\"fixedBidAmount\":9250.0}]}";
	
	@Before
	public void setupGson() {
		//gson = new Gson();
		GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		gson = build.create();
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
		//assertEquals(expected, gson.toJson(project));
	}
}
