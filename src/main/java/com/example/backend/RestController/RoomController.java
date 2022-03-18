package com.example.backend.RestController;

import java.util.Optional;

import com.example.backend.Model.Room;
import com.example.backend.Repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    	rm.setID(rm.getID());
    	rm.setID(rm.getID());
        rm.setRating(rm.getRating());
        rm.setStatus(rm.getStatus());
    	return repo.save(rm);
    }

     // Delete room
     @DeleteMapping("/{id}")
     public String updateReservation(@PathVariable long id) {
         repo.deleteById(id);
         return "room has been deleted";
     }
}
