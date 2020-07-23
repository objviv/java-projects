/**
 * 
 */
package com.intuit.martech.MarketPlace;

import java.time.Duration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author vkhanna
 *
 */

public class RedisConfiguration {
	
	private static JedisPool jedisPool;

	private RedisConfiguration() { 
		final JedisPoolConfig poolConfig = buildPoolConfig();
		jedisPool = new JedisPool(poolConfig, "localhost");
	}
	
	private JedisPoolConfig buildPoolConfig() {
	    final JedisPoolConfig poolConfig = new JedisPoolConfig();
	    poolConfig.setMaxTotal(128);
	    poolConfig.setMaxIdle(128);
	    poolConfig.setMinIdle(16);
	    poolConfig.setTestOnBorrow(true);
	    poolConfig.setTestOnReturn(true);
	    poolConfig.setTestWhileIdle(true);
	    poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
	    poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
	    poolConfig.setNumTestsPerEvictionRun(3);
	    poolConfig.setBlockWhenExhausted(true);
	    return poolConfig;
	}
	
	private static JedisPool getJedisPool() {
		if (null == jedisPool) {
			new RedisConfiguration();
		}
		return jedisPool;
	}
	
	public static Jedis getClient() { 
		Jedis client = getJedisPool().getResource();
		client.auth("password123");
		return client; 
	}
	
	public void initialize() { 
		//getClient().lpush("sellers", "{\"id\":\}")
	}
	
	
}
