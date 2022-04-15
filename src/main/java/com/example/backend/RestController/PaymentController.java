package com.example.backend.RestController;

import java.util.Optional;

import com.example.backend.Model.Message;
import com.example.backend.Model.Payment;
import com.example.backend.Model.Reservation;
import com.example.backend.Repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired PaymentRepository repo;

    //Retrieve all payments
    @GetMapping("")
    public Iterable<Payment> getAll() {
    	return repo.findAll();
    }

    //Retrieve a payment
    @GetMapping("/{paymentId}")
    public Payment getPayment(@PathVariable long paymentId) {
    	Optional<Payment> data = repo.findById(paymentId);
    	return data.get();
    }

    //Create a payment
    @PostMapping()
    public Payment addPaymentReservation(@RequestBody Payment payment) {
    	return repo.save(payment);
    }
    
    // Delete a payment
    @DeleteMapping("/{id}")
    public Message updateReservation(@PathVariable long id) {
    	repo.deleteById(id);
    	return new Message("Reservation delete");
    }
}
