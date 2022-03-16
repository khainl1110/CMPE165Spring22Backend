package com.example.backend.Repository;

import com.example.backend.Model.Reservation;

import org.springframework.data.repository.CrudRepository;

//CrudRepo will inherit several methods for finding reservation, saving, and delete
public interface ReservationRepository extends CrudRepository<Reservation, String> {
    //can define our own methods here
    Reservation findByEmailAddress(String customerEmail);

    Reservation findOne(Long id);
}
