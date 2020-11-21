package com.aaronkirchhoff.gettingfamiliarwithrouting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
//@RequestMapping("/coding")
public class GettingFamiliarWithRoutingApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(GettingFamiliarWithRoutingApplication.class, args);
	}
	
//	@RequestMapping("")
//	public String coding() {
//		return "hello coding dojo";
//	}
//	
//	@RequestMapping("/python")
//	public String python() {
//		return "Python/Django was awesome!";
//	}
//	
//	@RequestMapping("/java")
//	public String java() {
//		return "Java/Spring is better!";
//	}
	
//	@RequestMapping("/")
//	public String Hello() {
//		return "Hello! Welcome to my blank website!";
//	}

}
