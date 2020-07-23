/**
 * 
 */
package com.intuit.martech.MarketPlace;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

/**
 * @author vkhanna
 *
 */
public class SellerTest {
	
	private Gson gson;
	private static final String expected = "{\"id\":100,\"name\":\"Intuit MarTech\",\"projects\":[{\"id\":1,\"description\":\"Build a MarketPlace for self-employed.\",\"maxBudget\":10000.0,\"bidsAccepted\":{\"year\":2020,\"month\":8,\"dayOfMonth\":30,\"hourOfDay\":23,\"minute\":59,\"second\":59}},{\"id\":2,\"description\":\"Remind me of this.\",\"maxBudget\":1000.0,\"bidsAccepted\":{\"year\":2020,\"month\":8,\"dayOfMonth\":30,\"hourOfDay\":23,\"minute\":59,\"second\":59}}]}";
	
	@Before
	public void setupGson() {
		gson = new Gson();
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public void testToString() {
		Seller seller = new Seller(100, "Intuit MarTech");
		Project project = new Project(1, "Build a MarketPlace for self-employed.", 10000.00f, new GregorianCalendar(2020,8,30,23,59,59));
		seller.addProject(project);
		project = new Project(2, "Remind me of this.", 1000.00f, new GregorianCalendar(2020,8,30,23,59,59));
		seller.addProject(project);
		
		System.out.println(gson.toJson(seller));
		assertEquals(expected, gson.toJson(seller));
	}

}
