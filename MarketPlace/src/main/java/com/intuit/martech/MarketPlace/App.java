package com.intuit.martech.MarketPlace;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import redis.clients.jedis.Jedis;

/**
 * @author vkhanna
 *
 */
@SpringBootApplication
@RestController
public class App {
	
	public static final String SELLERS_KEY = "sellers";
	public static final String SELLERS_HASH_KEY = "sellersHash";
	public static final String BUYERS_KEY = "buyers";
	public static final String BUYERS_HASH_KEY = "buyersHash";
	public static final String PROJECTS_KEY = "projects";
	public static final String PROJECTS_HASH_KEY = "projectsHash";
	
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
    	
    	GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = build.create();
		
    	ret = (List<Seller>)gson.fromJson(s, ret.getClass());
        return ret;
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/sellers/{id}", method=RequestMethod.GET)
    Seller getSellerWithId(@PathVariable int id) {
    	if (client == null) {
    		client = (isTest?RedisConfiguration.getClientForTest():RedisConfiguration.getClient());
    		client.connect();
    	}
    	String s = client.hget(SELLERS_HASH_KEY, new Integer(id).toString());
    	
    	Seller ret = new Seller();
    	GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = build.create();
    	ret = (Seller)gson.fromJson(s, ret.getClass());
        return ret;
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/sellers/{id}/projects", method=RequestMethod.GET)
    List<Project> getSellerProjectsWithId(@PathVariable int id) {
    	if (client == null) {
    		client = (isTest?RedisConfiguration.getClientForTest():RedisConfiguration.getClient());
    		client.connect();
    	}
    	String s = client.hget(SELLERS_HASH_KEY, new Integer(id).toString());
    	
    	Seller ret = new Seller();
    	GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = build.create();
    	ret = (Seller)gson.fromJson(s, ret.getClass());
        return ret.getProjects();
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/sellers/{id}/projects", method=RequestMethod.POST, consumes = {"application/JSON"})
    List<Project> createSellerProjectsWithId(@PathVariable int id, @RequestBody Project project) {
    	if (client == null) {
    		client = (isTest?RedisConfiguration.getClientForTest():RedisConfiguration.getClient());
    		client.connect();
    	}
    	String s = client.hget(SELLERS_HASH_KEY, new Integer(id).toString());
    	
    	Seller ret = new Seller();
    	GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = build.create();
    	if (null != s && !s.isEmpty()) {
        	ret = (Seller)gson.fromJson(s, ret.getClass());
    	}
    	ret.addProject(project);
    	client.hset(App.SELLERS_HASH_KEY, new Integer(ret.getId()).toString(), gson.toJson(ret));
        return ret.getProjects();
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/buyers", method=RequestMethod.GET)
    List<Buyer> getBuyers() {
    	if (client == null) {
    		client = (isTest?RedisConfiguration.getClientForTest():RedisConfiguration.getClient());
    		client.connect();
    	}
    	String s = client.get(BUYERS_KEY);
    	
    	List<Buyer> ret = new ArrayList<Buyer>();
    	
    	GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = build.create();
		
    	ret = (List<Buyer>)gson.fromJson(s, ret.getClass());
        return ret;
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/buyers/{id}", method=RequestMethod.GET)
    Buyer getBuyerWithId(@PathVariable int id) {
    	if (client == null) {
    		client = (isTest?RedisConfiguration.getClientForTest():RedisConfiguration.getClient());
    		client.connect();
    	}
    	String s = client.hget(BUYERS_HASH_KEY, new Integer(id).toString());
    	
    	Buyer ret = new Buyer();
    	GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = build.create();
    	ret = (Buyer)gson.fromJson(s, ret.getClass());
        return ret;
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/buyers/{id}", method=RequestMethod.POST, consumes = {"application/JSON"})
    Buyer createBuyerBidsWithId(@PathVariable int id, @RequestBody Bid bid) {
    	if (client == null) {
    		client = (isTest?RedisConfiguration.getClientForTest():RedisConfiguration.getClient());
    		client.connect();
    	}
    	String s = client.hget(BUYERS_HASH_KEY, new Integer(id).toString());
    	
    	Buyer ret = new Buyer();
    	GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = build.create();
    	if (null != s && !s.isEmpty()) {
        	ret = (Buyer)gson.fromJson(s, ret.getClass());
    	}
    	ret.addBid(bid);
    	client.hset(App.BUYERS_HASH_KEY, new Integer(ret.getId()).toString(), gson.toJson(ret));
    	
    	s = client.hget(PROJECTS_HASH_KEY, new Integer(bid.getProjectId()).toString());
    	Project project = new Project();
    	if (null != s && !s.isEmpty()) {
        	project = (Project)gson.fromJson(s, project.getClass());
    	}
    	project.addBid(bid);
    	client.hset(App.PROJECTS_HASH_KEY, new Integer(project.getId()).toString(), gson.toJson(project));
        return ret;
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/projects/{id}", method=RequestMethod.GET)
    Project getProjectWithId(@PathVariable int id) {
    	if (client == null) {
    		client = (isTest?RedisConfiguration.getClientForTest():RedisConfiguration.getClient());
    		client.connect();
    	}
    	String s = client.hget(PROJECTS_HASH_KEY, new Integer(id).toString());
    	
    	Project ret = new Project();
    	GsonBuilder build = new GsonBuilder();
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarSerializer());
		build.registerTypeHierarchyAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = build.create();
    	ret = (Project)gson.fromJson(s, ret.getClass());
    	
    	List<Bid> bids = ret.getBids();
    	if (null != bids) {
    		Collections.sort(bids);
    		ret.setBids(bids);
    	}
        return ret;
    }
}
