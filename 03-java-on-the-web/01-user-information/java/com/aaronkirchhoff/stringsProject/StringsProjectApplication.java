package com.aaronkirchhoff.stringsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsProjectApplication.class, args);
	}

	@RequestMapping("/")
	public String Hello() {
		return "Hello! Welcome to my blank website!";
	}
	
	@RequestMapping("/random")
	public String random() {
		return "I'm no spring chicken, but spring boot is ok!";
	}
}

