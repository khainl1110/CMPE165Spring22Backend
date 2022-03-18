package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean isBooked; //completed/cancelled, booked
	private String hotelName;
	private int rating; //1-5 stars
	
	public Room() {
		
	}
	
	public Room(Long id, boolean isBooked, String hotelName, int rating) {
		this.id = id;
		this.isBooked = isBooked;
		this.hotelName = hotelName;
		this.rating = rating;
	}
	
	public Long getID() {
		return id;
	}
	
	public boolean getIsBooked() {
		return isBooked;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setIsBooked(boolean isBooked) {
		this.isBooked = isBooked; //true = booked, false = canceled/completed
	}
	
	public void toggleStatus() {
		isBooked = !isBooked;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
}