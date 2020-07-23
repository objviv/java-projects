/**
 * 
 */
package com.intuit.martech.MarketPlace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

/**
 * @author vkhanna
 *
 */
public class RedisClientTest {
	
	private static Jedis client;
	private Gson gson;
	
	@BeforeClass
	public static void setupClient() {
		//client = RedisConfiguration.getClient();
		client = new Jedis("localhost", 6379, 2000);
	}
	
	@Before
	public void setupGson() {
		gson = new Gson();
	}
	
	@Test
	public void getClient() {
		//client = RedisConfiguration.getClient();
		assertNotNull(client);
	}
	
	@Test
	public void performSimpleInsertAndLookup() {
		client.set("test", "123");
		String s = client.get("test");
		assertEquals(s, "123");
		
		client.del("test");
	}
	
	@Test
	public void performListInsertAndPop() {
		Seller seller1 = new Seller(100, "Intuit MarTech");
		//System.out.println(gson.toJson(seller1));
		client.lpush("test", gson.toJson(seller1));
		
		Seller seller2 = new Seller(101, "Intuit A4A");
		//System.out.println(gson.toJson(seller2));
		client.lpush("test", gson.toJson(seller2));
		
		
		String s = client.rpop("test");
		//System.out.println(s);
		assertEquals(gson.toJson(seller1), s);
		
		s = client.rpop("test");
		//System.out.println(s);
		assertEquals(gson.toJson(seller2), s);
		
		client.del("test");
	}
	
	@Test
	public void performListInsertAndLookup() {
		List<Seller> sellers = new ArrayList<Seller>();
		Seller seller = new Seller(100, "Intuit MarTech");
		sellers.add(seller);
		seller = new Seller(101, "Intuit A4A");
		sellers.add(seller);
		
		client.set("test", gson.toJson(sellers));
		//System.out.println(gson.toJson(sellers));
		
		String s = client.get("test");
		//System.out.println(s);
		assertEquals(gson.toJson(sellers), s);
		
		client.del("test");
	}
	
	@Test
	public void performListInsertAndLookup2() {
		List<Seller> sellers = new ArrayList<Seller>();
		Seller seller = new Seller(100, "Intuit MarTech");
		sellers.add(seller);
		
		//System.out.println(gson.toJson(sellers));
		client.set("test", gson.toJson(sellers));
		
		String s = client.get("test");
		//System.out.println(s);
		sellers = (List<Seller>)gson.fromJson(s, sellers.getClass());
		
		seller = new Seller(101, "Intuit A4A");
		sellers.add(seller);
		
		//System.out.println(gson.toJson(sellers));
		client.set("test", gson.toJson(sellers));
		
		s = client.get("test");
		//System.out.println(s);
		assertEquals(gson.toJson(sellers), s);
		
		client.del("test");
	}
	
	@Test
	public void initializeMarketplace() {
		List<Seller> sellers = new ArrayList<Seller>();
		Seller seller = new Seller(100, "Intuit MarTech");
		Project project = new Project(1, "Build a MarketPlace for self-employed.", 10000.00f, new GregorianCalendar(2020,8,31,23,59,59));
		seller.addProject(project);
		sellers.add(seller);
		seller = new Seller(101, "Intuit A4A");
		sellers.add(seller);
		seller = new Seller(102, "Intuit Marketing");
		sellers.add(seller);
		
		Gson gson = new Gson();
		client.set(App.SELLERS_KEY, gson.toJson(sellers));
	}
}
