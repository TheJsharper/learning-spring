package com.learningspringboot.learningspring.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learningspringboot.learningspring.data.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

	
	
	
}
