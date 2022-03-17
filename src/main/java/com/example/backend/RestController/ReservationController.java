package com.example.backend.RestController;

import java.util.List;
import java.util.Optional;

import com.example.backend.Model.Reservation;
import com.example.backend.Repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired ReservationRepository reserRepo;

    //Retrieve all reservations
    @GetMapping("")
    public Iterable<Reservation> getAll() {
    	return reserRepo.findAll();
    }

    //Retrieve a reservation
    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
    	Optional<Reservation> data = reserRepo.findById(id);
    	return data.get();
    }
    
    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.GET)
	public Reservation getReservation(@PathVariable String id) {
		return reservationService.getReservation(id);
	}

    //Create a reservation
    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
	public void addReservation(@RequestBody Reservation reservation) {
	    reservationService.addReservation(reservation);
		
	}

    //Update reservation
    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.PUT)
	public void updateReservation(@RequestBody Reservation reservation,@PathVariable String id) {
		reservationService.updateReservation(id, reservation);
	}    
}
