package com.learningspringboot.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;

import com.learningspringboot.learningspring.data.Room;
import com.learningspringboot.learningspring.utils.AppStartupEvent;

import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication (scanBasePackages =   {"com.learningspringboot.learningspring.*.*"})
public class LearningSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(LearningSpringApplication.class);
	public static void main(String[] args) {
		
		/*;*/var context =new SpringApplication(LearningSpringApplication.class);
		context.run(args);
		context.addListeners(new AppStartupEvent());
		//SpringApplication.run(LearningSpringApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	  public void EventListenerExecute() {
	    System.out.println("Application Ready Event is successfully Started");
	    /*var webClient = WebClient.create("http://localhost:8080");

        Mono<Room> result = webClient.get()
                .retrieve()
                .bodyToMono(Room.class);

        result.subscribe(res -> logger.info("{}", res));*/
	  }

}
