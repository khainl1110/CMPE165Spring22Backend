package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String hotelName;
	private String image;
	private double rating; //1-10 points with 10 is highest
	private String description;
	private int price;
	private boolean isBooked;
	
	public Room() {
		
	}
	
	public Room(String hotelName, String image, double rating, String description, int price, boolean isBooked) {
		super();
		this.hotelName = hotelName;
		this.image = image;
		this.rating = rating;
		this.description = description;
		this.price = price;
		this.isBooked = isBooked;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
	
	public double getRating() {
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
	
	public void setRating(double rating) {
		this.rating = rating;
	}
}