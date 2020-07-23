/**
 * 
 */
package com.intuit.martech.MarketPlace;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author vkhanna
 *
 */

public class RedisConfiguration {
	
	//private static final String   RedisHost = "127.0.0.1";
	private static final String   RedisHostTest = "localhost";
	private static final String   RedisHost = "host.docker.internal";
	private static final int      RedisPort=6379;
	private static final int      RedisConnectionTimeout=2000;
	private static final int      RedisMaximumWaitTime=1000;
	private static final int      RedisMaximumIdleConnectionCount=20;
	private static final int      RedisMaximumActiveConnectionCount=300;
	
	private static JedisPool jedisPool;

	private RedisConfiguration() { 
		final JedisPoolConfig poolConfig = buildPoolConfig();
		jedisPool = new JedisPool(poolConfig, RedisHost, RedisPort, RedisConnectionTimeout);
	}
	
	private JedisPoolConfig buildPoolConfig() {
	    final JedisPoolConfig poolConfig = new JedisPoolConfig();
	    poolConfig.setMaxTotal(RedisMaximumActiveConnectionCount);
	    poolConfig.setMaxIdle(RedisMaximumIdleConnectionCount);
	    poolConfig.setMaxWaitMillis(RedisMaximumWaitTime);
	    //poolConfig.setMinIdle(16);
	    //poolConfig.setTestOnBorrow(true);
	    //poolConfig.setTestOnReturn(true);
	    //poolConfig.setTestWhileIdle(true);
	    //poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
	    //poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
	    //poolConfig.setNumTestsPerEvictionRun(3);
	    //poolConfig.setBlockWhenExhausted(true);
	    return poolConfig;
	}
	
	/**
	 * 
	 * @return
	 */
	public static JedisPool getJedisPool() {
		if (null == jedisPool) {
			new RedisConfiguration();
		}
		return jedisPool;
	}
	
	/**
	public static Jedis getClient() { 
		Jedis client = getJedisPool().getResource();
		client.getClient().setTimeoutInfinite();
		//client.auth("password123");
		return client; 
	}
	*/
	
	/**
	 * 
	 * @return
	 */
	public static Jedis getClient() { 
		Jedis client = new Jedis(RedisHost, RedisPort, RedisConnectionTimeout);
		return client; 
	}
	
	/**
	 * 
	 * @return
	 */
	public static Jedis getClientForTest() { 
		Jedis client = new Jedis(RedisHostTest, RedisPort, RedisConnectionTimeout);
		return client; 
	}
	
	public void initialize() { 
		//getClient().lpush("sellers", "{\"id\":\}")
	}
	
	
}
