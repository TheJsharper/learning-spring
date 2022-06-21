package com.learningspringboot.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages =   {"com.learningspringboot.learningspring.*.*"})
public class LearningSpringApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LearningSpringApplication.class, args);
	}

}
