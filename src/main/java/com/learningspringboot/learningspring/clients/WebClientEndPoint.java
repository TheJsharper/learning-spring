package com.learningspringboot.learningspring.clients;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.learningspringboot.learningspring.api.RoomRepository;
import com.learningspringboot.learningspring.data.Room;

import reactor.core.publisher.Mono;

@Component
public class WebClientEndPoint {

	private final WebClient client;
	private final RoomRepository roomRepository;

	@Autowired
	public WebClientEndPoint(WebClient.Builder builder, RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
		this.client = builder.baseUrl("http://localhost:8080").build();
	}

	public Mono<List<Room>> getMessage() {
		var rooms = this.roomRepository.findAll();
		var listOfRoom = StreamSupport.stream(rooms.spliterator(), false).collect(Collectors.toList());
		System.out.println("====> WebClient--->" + listOfRoom.size());
		return this.client.get().uri("/reactive").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Room>>() {
				});
	}
}
