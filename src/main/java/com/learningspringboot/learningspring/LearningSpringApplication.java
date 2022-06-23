package com.learningspringboot.learningspring;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;

import com.learningspringboot.learningspring.api.RoomRepository;
import com.learningspringboot.learningspring.data.Room;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class LearningSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(LearningSpringApplication.class);

	public static void main(String[] args) {

		var context = SpringApplication.run(LearningSpringApplication.class, args);

		/*var repo = context.getBean(RoomRepository.class);

		Iterable<Room> rooms = repo.findAll();
		var list = StreamSupport.stream(rooms.spliterator(), false).collect(Collectors.toList());
		logger.debug("===>LENGTH MAIN" + list.size());
		list.forEach(System.out::println);*/

	}

	@EventListener(ApplicationReadyEvent.class)
	public void EventListenerExecute() {
		System.out.println("Application Ready Event is successfully Started");

		/*var webClient = WebClient.create("http://localhost:8080");

		Mono<Room> result = null;
		try {
			result = webClient.get().uri(new URI("/reactive")).
					retrieve().bodyToMono(Room.class);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result.subscribe(res -> logger.info("{}", res));*/

	}

	@EventListener(ApplicationFailedEvent.class)
	public void EventListenerExecuteFailed() {
		System.out.println("Application Event Listener is Failed");
	}

}
