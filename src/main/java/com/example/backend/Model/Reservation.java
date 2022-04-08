package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long roomId; //point to room
	private String userEmail; // point to user's email
	private long paymentId;

	public Reservation() {
		
	}
	

	public Reservation(String email, long id, long payment_id) {
		userEmail = email;
		roomId = id;
		this.paymentId = payment_id;
	}
	
	// need this so JPA can automatically create id
	public long getId() {
		return id;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public long getRoomId() {
		return roomId;
	}
	
	public long getPaymentID() {
		return paymentId;
	}
	
	public void setPaymentID(long paymentId) {
		this.paymentId = paymentId;
	}
	
	public void setUserEmail(String email) {
		userEmail = email;
	}
	
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
}