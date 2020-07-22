package com.intuit.martech.MarketPlace;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vkhanna
 *
 */
@SpringBootApplication
@RestController
public class App {
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/sellers", method=RequestMethod.GET)
    List<Seller> getSellers() {
    	List<Seller> ret = new ArrayList<Seller>();
    	ret.add(new Seller("100","Intuit MarTech"));
        return ret;
    }
}
