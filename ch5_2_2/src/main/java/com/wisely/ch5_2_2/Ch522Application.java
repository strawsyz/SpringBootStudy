package com.wisely.ch5_2_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Ch522Application {
	
	@Value("${book.name}")
	private String bookName;
	@Value("${book.user}")
	private String bookUser;
	@RequestMapping("/")
	String index(){
		return "BookName is " +bookName+",BookUser is " +bookUser +"!!";
	}
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Ch522Application.class);
		app.setBannerMode(Banner.Mode.OFF);//关闭Banner
		app.run(args);//启动SpringBoot项目
	}
}
