package com.learningspringboot.learningspring.reactive.repositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.learningspringboot.learningspring.data.Room;
@Repository
public interface ReactiveRoomRepository extends ReactiveCrudRepository<Room, Long>/**/{

	

}
