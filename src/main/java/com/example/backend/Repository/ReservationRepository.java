package com.example.backend.Repository;

import com.example.backend.Model.Reservation;

import org.springframework.data.repository.CrudRepository;

//CrudRepo will inherit several methods for finding reservation, saving, and delete
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    //can define our own methods here
    Iterable<Reservation> findByUserEmail(String userEmail);

}
