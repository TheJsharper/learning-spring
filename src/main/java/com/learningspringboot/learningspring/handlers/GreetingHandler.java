package com.learningspringboot.learningspring.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.learningspringboot.learningspringa.api.RoomRepository;

import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

	private final RoomRepository roomRepository;

	@Autowired
	public GreetingHandler(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	public Mono<ServerResponse> hello(ServerRequest request) {
		var rooms = this.roomRepository.findAll();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(rooms));
	}
}
