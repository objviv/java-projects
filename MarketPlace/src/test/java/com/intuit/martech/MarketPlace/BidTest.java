/**
 * 
 */
package com.intuit.martech.MarketPlace;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author vkhanna
 *
 */
public class BidTest {

	private Gson gson;
	private static final String expected = "{\"fixedBidAmount\":10000.0}";
	
	@Before
	public void setupGson() {
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
		Bid bid = new Bid(10000.00f);
		
		System.out.println(gson.toJson(bid));
		//assertEquals(expected, gson.toJson(bid));
	}

}
