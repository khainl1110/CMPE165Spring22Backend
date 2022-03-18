package com.example.backend.RestController;

import java.util.Optional;

import com.example.backend.Model.Message;
import com.example.backend.Model.Room;
import com.example.backend.Repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired RoomRepository repo;

    //get all the rooms
    @GetMapping("")
    public Iterable<Room> getAll() {
    	return repo.findAll();
    }

    //get a room
    @GetMapping("/{id}")
    public Room getReservation(@PathVariable long id) {
    	Optional<Room> data = repo.findById(id);
    	return data.get();
    }

    //Create a room
    @PostMapping()
    public Room addReservation(@RequestBody Room room) {
    	return repo.save(room);
    }
    
    //Update room
    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room room, @PathVariable long id) {
    	Optional<Room> data = repo.findById(id);
    	Room rm = data.get();
    	
    	rm.setHotelName(room.getHotelName());
    	rm.setRating(rm.getRating());
        rm.setIsBooked(rm.getIsBooked());
        
    	return repo.save(rm);
    }

     // Delete room
     @DeleteMapping("/{id}")
     public Message updateReservation(@PathVariable long id) {
         repo.deleteById(id);
         return new Message("room has been deleted");
     }
}