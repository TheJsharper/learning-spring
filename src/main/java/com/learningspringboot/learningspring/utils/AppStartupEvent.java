package com.learningspringboot.learningspring.utils;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learningspringboot.learningspring.api.RoomRepository;
import com.learningspringboot.learningspring.data.Room;

@Component
@Order(value = 1)
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

	private RoomRepository roomRepository;

	public AppStartupEvent(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;

		System.out.println("Construct---------------------");

	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		System.out.println("NEIEN" + this.roomRepository);
		Iterable<Room> rooms = this.roomRepository.findAll();
		var list = StreamSupport.stream(rooms.spliterator(), false).collect(Collectors.toList());
		System.out.println("lenGHT--->" + list.size());
		rooms.forEach(r -> System.out.println("===>" + r));

		System.out.println("====== onApplicationEvent ===");
		// this.iterator.forEach(System.out::println);

	}

}
