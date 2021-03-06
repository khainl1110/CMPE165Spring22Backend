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
	private String location; //area, city
	private double rating; //1-10 points with 10 is highest
	private String description;
	private int price;
	private int numGuest;
	private boolean isBooked;
	private String roomInfo;
	private String amenities;
	
	public Room() {
		
	}
	
	public Room(String location, int numGuest) {
		this.location = location;
		this.numGuest = numGuest;
	}
	
	public Room(String hotelName, String location, String image, double rating, String description, String amenities, String roomInfo, int price, int numGuest, boolean isBooked) {
		super();
		this.hotelName = hotelName;
		this.location = location;
		this.image = image;
		this.rating = rating;
		this.description = description;
		this.price = price;
		this.isBooked = isBooked;
		this.numGuest = numGuest;
		this.roomInfo = roomInfo;
		this.amenities = amenities;
	}

	public Long getId() {
		return id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRating() {
		return rating;
	}
	
	public int getNumGuest() {
		return numGuest;
	}
	
	public void setNumGuest(int guests) {
		numGuest = guests;
	}

	public void setRating(double rating) {
		this.rating = rating;
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

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	
	public String getAmenities() {
		return amenities;
	}
	
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	
	public String getRoomInfo() {
		return roomInfo;
	}
	
	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}

	public void toogleAvail() {
		if(this.isBooked)
			this.isBooked = false;
		else this.isBooked = true;
	}
		
	// checks whether the room matches the booking criteria
	public boolean isMatchedBookingCriterias(Room room) {
		if (getNumGuest() == room.getNumGuest()
				&& getLocation().toLowerCase().contains(room.getLocation().toLowerCase())
				&& isBooked == false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Room [hotelName=" + hotelName + ", image=" + image + ", location=" + location + ", rating=" + rating
				+ ", description=" + description + ", price=" + price + ", numGuest=" + numGuest + ", isBooked="
				+ isBooked + ", roomInfo=" + roomInfo + ", amenities=" + amenities + "]";
	}
}