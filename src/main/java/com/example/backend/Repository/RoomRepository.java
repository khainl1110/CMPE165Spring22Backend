package com.example.backend.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.backend.Model.Room;

public interface RoomRepository extends CrudRepository<Room, Long>{
	
}
