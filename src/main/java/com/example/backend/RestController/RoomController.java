package com.example.backend.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.backend.Model.LoadRoom;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired RoomRepository repo;

    @PostConstruct
    private void loadRoom() {
    	LoadRoom loadRoom = new LoadRoom();
    	repo.saveAll(LoadRoom.getRooms());
    }
    
    
    //get all the rooms
    @GetMapping("")
    public Iterable<Room> getAll() {
    	return repo.findAll();
    }

    //get a room
    @GetMapping("/{id}")
    public Room getRoom(@PathVariable long id) {
    	Optional<Room> data = repo.findById(id);
    	return data.get();
    }
    
    //Create a room
    @PostMapping()
    public Room addRoom(@RequestBody Room room) {
    	return repo.save(room);
    }
    
    // toggle a room's availability
    @GetMapping("/{id}/toggle")
    public Room toggleRoomAvail(@PathVariable long id) {
    	Optional<Room> data = repo.findById(id);
    	Room room = data.get();
    	room.toogleAvail();
    	return repo.save(room);
    }
    
    //Update room
    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room room, @PathVariable long id) {
    	
    	Optional<Room> data = repo.findById(id);
    	Room rm = data.get();
    	
    	rm.setHotelName(room.getHotelName());
    	rm.setImage(room.getImage());
    	rm.setRating(rm.getRating());
    	rm.setDescription(room.getDescription());
    	rm.setPrice(room.getPrice());
        rm.setBooked(room.isBooked());
        rm.setNumGuest(room.getNumGuest());
        rm.setLocation(room.getLocation());
        rm.setAmenities(room.getAmenities());
        rm.setRoomInfo(room.getRoomInfo());
        
    	return repo.save(rm);
    }

     // Delete room
     @DeleteMapping("/{id}")
     public Message updateReservation(@PathVariable long id) {
         repo.deleteById(id);
         return new Message("room has been deleted");
     }
     
     @GetMapping("/search")
     public List<Room> fetchRoom(@RequestParam("location") String location, @RequestParam("numGuest") int numGuest) {
    	 Iterable<Room> data = repo.findAll();
    	 List<Room> rooms = new ArrayList<>();
    	 Room room = new Room(location, numGuest); //replace hypens if there are any
    	 
    	 for (Room r : data) {
    		 if (r.isMatchedBookingCriterias(room)) {
    			 rooms.add(r);
    		 }
    	 }
    	 return rooms;
     }
}