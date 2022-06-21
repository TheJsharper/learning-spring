package com.learningspringboot.learningspring.utils;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learningspringboot.learningspringa.api.RoomRepository;

@Component
@Order(0)
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{
	private final RoomRepository roomRepository;
	
	public AppStartupEvent(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
		System.out.println("Construct---------------------");
				
		
	}
	
	@Override
	//@EventListener(ApplicationReadyEvent.class)
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println("======");
		this.roomRepository.findAll().forEach(System.out::println);
		
	}

}
