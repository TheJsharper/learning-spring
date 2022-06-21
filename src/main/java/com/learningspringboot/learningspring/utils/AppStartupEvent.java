package com.learningspringboot.learningspring.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learningspringboot.learningspring.data.Room;
import com.learningspringboot.learningspringa.api.RoomRepository;

@Component
@Order(0)
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{
	@Autowired
	private  RoomRepository roomRepository;
	private Iterable<Room> iterator;
	
	/**/public AppStartupEvent(/*RoomRepository roomRepository*/) {
		//this.roomRepository = roomRepository;
		System.out.println("Construct---------------------");
				
		//this.iterator =this.roomRepository.findAll();
		
	}
	@PostConstruct
    public void init() {
       // LOG.info(Arrays.asList(environment.getDefaultProfiles()));
		System.out.println("======");
    }
	
	@Override
	//@EventListener(ApplicationReadyEvent.class)
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		//this.iterator.forEach(System.out::println);
		
	}

}
