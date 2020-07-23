/**
 * 
 */
package com.intuit.martech.MarketPlace;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

/**
 * @author vkhanna
 *
 */
public class RedisClientTest {
	
	private Jedis client;
	
	@Before
	public void setupClient() {
		this.client = RedisConfiguration.getClient();
	}
	
	@Test
	public void getClient() {
		//client = RedisConfiguration.getClient();
		assertNotNull(client);
	}
	
	
	
	@Test
	public void performInsertAndLookup() {
		//client.s
	}
	
}
