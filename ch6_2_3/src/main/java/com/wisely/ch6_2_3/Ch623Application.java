package com.wisely.ch6_2_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.ch6_2_3.config.AuthorSettings;

@RestController
@SpringBootApplication
public class Ch623Application {
	
	@Autowired
	private AuthorSettings author;
	
	@RequestMapping("/")
	public String index(){
		return "author name is "+author.getName()+" and author age is "+author.getAge();	
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Ch623Application.class, args);
	}
}
