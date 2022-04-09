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

	private double price;
	private String check_in;
	private String check_out;
	private int numGuest;


	public Reservation() {
		
	}
	
	public Reservation(String email, long id) {
		userEmail = email;
		roomId = id;
	}
	
	public Reservation(String email, long id, long paymentId) {
		userEmail = email;
		roomId = id;
		this.paymentId = paymentId;
	}
	
	

	public Reservation(long id, long roomId, String userEmail, long paymentId, double price, String check_in,
			String check_out, int numGuest) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.userEmail = userEmail;
		this.paymentId = paymentId;
		this.price = price;
		this.check_in = check_in;
		this.check_out = check_out;
		this.numGuest = numGuest;
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

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCheck_in() {
		return check_in;
	}


	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}


	public String getCheck_out() {
		return check_out;
	}


	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}


	public int getNumGuest() {
		return numGuest;
	}


	public void setNumGuest(int numGuest) {
		this.numGuest = numGuest;
	}

	public void setUserEmail(String email) {
		userEmail = email;
	}
	
	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
}