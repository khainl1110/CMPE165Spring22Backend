package com.example.backend.RestController;

import java.util.List;

import com.example.backend.Model.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
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

    //Retrieve all reservations
    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public List getAllReservation() {
		return reservationService.getAllReservation();
    }

    //Retrive a reservation
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
