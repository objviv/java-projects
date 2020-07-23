package com.intuit.martech.MarketPlace;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

/**
 * @author vkhanna
 *
 */
@SpringBootApplication
@RestController
public class App {
	
	public static final String SELLERS_KEY = "sellers";
	private static Jedis client;
	
	private boolean isTest = false;
	public App() {}
	public App(boolean isTest) {
		this.isTest = isTest;
	}
	
	/**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/sellers", method=RequestMethod.GET)
    List<Seller> getSellers() {
    	if (client == null) {
    		client = (isTest?RedisConfiguration.getClientForTest():RedisConfiguration.getClient());
    		client.connect();
    	}
    	String s = client.get(SELLERS_KEY);
    	
    	List<Seller> ret = new ArrayList<Seller>();
    	Gson gson = new Gson();
    	ret = (List<Seller>)gson.fromJson(s, ret.getClass());
        return ret;
    }
}
