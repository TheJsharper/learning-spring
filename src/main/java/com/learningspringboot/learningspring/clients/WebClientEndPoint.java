package com.learningspringboot.learningspring.clients;

import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.learningspringboot.learningspring.data.Room;
import com.learningspringboot.learningspringa.api.RoomRepository;

@Component
public class WebClientEndPoint {

	private final WebClient client;
	private final RoomRepository roomRepository;

	public WebClientEndPoint(WebClient.Builder builder, RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
		this.client = builder.baseUrl("http://localhost:8080").build();
	}

	public Mono<String> getMessage() {
		var rooms = this.roomRepository.findAll();
		return this.client.get().uri("/reactive").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Room.class)
				.map(Room::getName);
	}
}
