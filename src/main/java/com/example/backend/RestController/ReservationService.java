package com.example.backend.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.Model.Reservation;
import com.example.backend.Repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//call methods in the repository
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //Retrieve all rows from table
    public List getAllReservation() {
        List reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        return reservations;   
    }
    
    //Retrieve one row from table
    public Reservation getReservation(Long id) {
        return reservationRepository.findOne(id);
    }
    
    //Insert row into table
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    //Updates row in table
    public void updateReservation(Long id, Reservation reservation) {
        reservationRepository.save(reservation);
    }
    //Delete row from table
    public void deleteReservation(Long id) {
		reservationRepository.delete(id);
	}

}
