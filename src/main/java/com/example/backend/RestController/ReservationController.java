package com.example.backend.RestController;

import java.util.Optional;

import com.example.backend.Model.Message;
import com.example.backend.Model.Reservation;
import com.example.backend.Model.User;
import com.example.backend.Repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    
    @Autowired ReservationRepository repo;

    //Retrieve all reservations
    @GetMapping("")
    public Iterable<Reservation> getAll() {
    	return repo.findAll();
    }

    //Retrieve a reservation
    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable long id) {
    	Optional<Reservation> data = repo.findById(id);
    	return data.get();
    }
    
    //Create a reservation
    @PostMapping()
    public Reservation addReservation(@RequestBody Reservation reservation) {
    	return repo.save(reservation);
    }

    //Update reservation
    @PutMapping("/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable long id) {
    	Optional<Reservation> data = repo.findById(id);
    	Reservation reser = data.get();
    	reser.setUserEmail(reservation.getUserEmail());
    	reser.setRoomId(reservation.getRoomId());
    	
    	return repo.save(reser);
    }
    
    // Delete reservation
    @DeleteMapping("/{id}")
    public Message updateReservation(@PathVariable long id) {
    	repo.deleteById(id);
    	return new Message("Reservation delete");
    }
    
    // find reservation by email
    // guide: https://stackoverflow.com/questions/27066437/how-to-see-result-of-findbyusername-delievered-by-crudrepository
    // url: localhost:8080/reservation/find?userEmail=[email]
    @GetMapping("/find")
    public Iterable<Reservation> findByUsername(@RequestParam("userEmail") String username) {
    	return repo.findByUserEmail(username);
    }
    
}
