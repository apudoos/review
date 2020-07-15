package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	@Primary
	public String message() {
		System.out.println("message bean created");
		return "Hello, Spring";
	}

	@Bean
	public String uppercaseMessage(MessageService ms) {
		System.out.println("uppercaseMessage bean created: " + ms.uppercase());
		return ms.uppercase();
	}

	@Bean
	public String lowercaseMessage(MessageService ms) {
		System.out.println("lowercaseMessage bean created: " + ms.lowercase());
		return ms.lowercase();
	}


}
