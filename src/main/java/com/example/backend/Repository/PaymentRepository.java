package com.example.backend.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.backend.Model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{
	

}
