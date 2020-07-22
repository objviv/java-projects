package com.intuit.martech.MarketPlace;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 * 
 * @author vkhanna
 *
 */

public class AppTest {

	@Test
	public void testGetSellersNull() {
		RestAssuredMockMvc.standaloneSetup(new App());
		
		given().
			when().
        		get("/sellers").
        	then().
        		assertThat().statusCode(200);
	}

}