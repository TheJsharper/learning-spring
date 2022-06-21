package com.learningspringboot.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learningspringboot.learningspring.utils.AppStartupEvent;

@SpringBootApplication (scanBasePackages =   {"com.learningspringboot.learningspring.*.*"})
public class LearningSpringApplication {

	public static void main(String[] args) {
		
		/*;*/var context =new SpringApplication(LearningSpringApplication.class);
		context.addListeners(new AppStartupEvent());
		context.run(args);
		//SpringApplication.run(LearningSpringApplication.class, args);
	}

}
