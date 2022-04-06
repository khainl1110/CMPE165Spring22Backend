package com.example.backend.RestController;

import java.util.Optional;

import com.example.backend.Model.Reservation;
import com.example.backend.Repository.PaymentReservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentReservationController {

    @Autowired PaymentReservation repo;

    //Retrieve all payments
    @GetMapping("")
    public Iterable<Reservation> getAll() {
    	return repo.findAll();
    }

    //Retrieve a payment
    @GetMapping("/{payment_id}")
    public Reservation getPaymentReservation(@PathVariable long payment_id) {
    	Optional<Reservation> data = repo.findById(payment_id);
    	return data.get();
    }

    //Create a payment
    @PostMapping()
    public Reservation addPaymentReservation(@RequestBody Reservation payment) {
    	return repo.save(payment);
    }
    
}
