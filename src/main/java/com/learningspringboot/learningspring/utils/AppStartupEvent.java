package com.learningspringboot.learningspring.utils;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.learningspringboot.learningspringa.api.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
	private final RoomRepository roomRepository;
	
	public AppStartupEvent(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
				
		
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		this.roomRepository.findAll().forEach(System.out::println);
		
	}

}
