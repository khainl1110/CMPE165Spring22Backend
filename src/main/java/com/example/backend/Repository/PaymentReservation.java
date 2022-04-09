package com.example.backend.Repository;

import com.example.backend.Model.Reservation;

import org.springframework.data.repository.CrudRepository;

public interface PaymentReservation extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findById();
    
}
