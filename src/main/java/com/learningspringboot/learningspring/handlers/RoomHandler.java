package com.learningspringboot.learningspring.handlers;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.learningspringboot.learningspring.api.RoomRepository;

import reactor.core.publisher.Mono;

@Component
public class RoomHandler {

	private final RoomRepository roomRepository;

	@Autowired(required = true)
	public RoomHandler(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	public Mono<ServerResponse> getResponseRoom(ServerRequest request) {
		var rooms = this.roomRepository.findAll();
		var listOfRoom = StreamSupport.stream(rooms.spliterator(), false).collect(Collectors.toList());
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(listOfRoom));
	}
}
