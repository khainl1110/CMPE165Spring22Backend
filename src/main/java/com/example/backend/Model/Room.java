package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean status; //completed/cancelled, booked
	private String hotelName;
	private int rating; //1-5 stars
	
	public Room() {
		
	}
	
	public Room(Long id, boolean status, String hotelName, int rating) {
		this.id = id;
		this.status = status;
		this.hotelName = hotelName;
		this.rating = rating;
	}
	
	public Long getID() {
		return id;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public String getName() {
		return hotelName;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	
	public void setStatus(boolean status) {
		this.status = status; //true = booked, false = canceled/completed
	}
	
	public void toggleStatus() {
		status = !status;
	}
	
	public void setName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
}