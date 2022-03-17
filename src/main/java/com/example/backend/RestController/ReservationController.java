package com.example.backend.RestController;

import java.util.Optional;

import com.example.backend.Model.Reservation;
import com.example.backend.Model.User;
import com.example.backend.Repository.ReservationRepository;

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
    

    // test method
    @PostMapping("/t")
    public long testRe(@RequestBody Reservation reservation) {
    	return reservation.getroomId();
    }
    
    // test method1
    @PostMapping("/t1")
    public String testRe1(@RequestBody Reservation reservation) {
    	return reservation.getUserEmail();
    }
    
    // test method2
    @PostMapping("/t2")
    public Reservation testRe2(@RequestBody Reservation reservation) {
    	return reservation;
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
    	reser.setroomId(reservation.getroomId());
    	
    	return repo.save(reser);
    }
    
    // Delete reservation
    @DeleteMapping("/{id}")
    public String updateReservation(@PathVariable long id) {
    	repo.deleteById(id);
    	return "delete";
    }
    
    // find reservation by email
    // guide: https://stackoverflow.com/questions/27066437/how-to-see-result-of-findbyusername-delievered-by-crudrepository
    @GetMapping("/find")
    public Iterable<Reservation> findByUsername(@RequestParam("userEmail") String username) {
    	return repo.findByUserEmail(username);
    }
}
