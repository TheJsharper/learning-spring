package com.learningspringboot.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;

import com.learningspringboot.learningspring.data.Room;
import com.learningspringboot.learningspring.utils.AppStartupEvent;

import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*@SpringBootApplication(scanBasePackages = { "com.learningspringboot.learningspring",
		"com.learningspringboot.learningspring.data", "com.learningspringboot.learningspring.api", "com.learningspringboot.learningspring.utils",
		"com.learningspringboot.learningspring.clients", "com.learningspringboot.learningspring.handlers", "com.learningspringboot.learningspring.routes"})*/
@SpringBootApplication //(scanBasePackages ={"com.learningspringboot.learningspring.*.*"})
/*@ComponentScan(value = {"com.learningspringboot.learningspring",
		"com.learningspringboot.learningspring.data", "com.learningspringboot.learningspring.api", "com.learningspringboot.learningspring.utils",
		"com.learningspringboot.learningspring.clients", "com.learningspringboot.learningspring.handlers", "com.learningspringboot.learningspring.routes"})*/
public class LearningSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(LearningSpringApplication.class);

	public static void main(String[] args) {

		/* ; var context = new SpringApplication(LearningSpringApplication.class);
		context.addListeners(new AppStartupEvent());

		context.run(args);*/
		 SpringApplication.run(LearningSpringApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void EventListenerExecute() {
		System.out.println("Application Ready Event is successfully Started");
		/*
		 * var webClient = WebClient.create("http://localhost:8080");
		 * 
		 * Mono<Room> result = webClient.get() .retrieve() .bodyToMono(Room.class);
		 * 
		 * result.subscribe(res -> logger.info("{}", res));
		 */
	}

}
