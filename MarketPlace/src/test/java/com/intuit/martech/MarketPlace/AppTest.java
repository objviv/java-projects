package com.intuit.martech.MarketPlace;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.mapper.TypeRef;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.response.ResponseBodyExtractionOptions;

/**
 * 
 * @author vkhanna
 *
 */

public class AppTest {

	@Test
	public void testGetSellers() {
		RestAssuredMockMvc.standaloneSetup(new App(true));
		
		given().
			when().
        		get("/sellers").
        	then().
        		assertThat().statusCode(200);
		
		// Extract
		List<Map<String, Object>> sellers = get("/sellers").as(new TypeRef<List<Map<String, Object>>>() {});
		assertThat(sellers, Matchers.hasSize(3));
		assertThat((Double)sellers.get(0).get("id"), Matchers.equalTo(100.0d));
		assertThat((String)sellers.get(0).get("name"), Matchers.equalTo("Intuit MarTech"));
		assertThat((Double)sellers.get(1).get("id"), Matchers.equalTo(101.0d));
	}
	
	@Test
	public void testGetSellersProject() {
		RestAssuredMockMvc.standaloneSetup(new App(true));
		
		given().
			when().
        		get("/sellers").
        	then().
        		assertThat().statusCode(200);
		
		// Extract
		List<Map<String, Object>> sellers = get("/sellers").as(new TypeRef<List<Map<String, Object>>>() {});
		List<Map<String, Object>> projects = (List<Map<String, Object>>) sellers.get(0).get("projects");
		assertThat(projects, Matchers.hasSize(2));
		assertThat((Double)projects.get(0).get("id"), Matchers.equalTo(1.0d));
		assertThat((String)projects.get(0).get("description"), Matchers.equalTo("Build a MarketPlace for self-employed."));
		assertThat((Double)projects.get(1).get("id"), Matchers.equalTo(2.0d));
	}
}