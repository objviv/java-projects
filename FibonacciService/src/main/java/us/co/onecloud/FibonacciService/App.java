package us.co.onecloud.FibonacciService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {
	
	us.co.onecloud.Fibonacci.App fib = new us.co.onecloud.Fibonacci.App();
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/fibonacci/{term}")
    Fibonacci getFibonacci(@PathVariable int term) {
    	Fibonacci ret = new Fibonacci(term, fib.fibonacci(term));
        return ret;
    }
}