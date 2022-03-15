package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	private int roomID; //point to room
	private String customerEmail;
	
	public Reservation() {
		
	}
	
	public Reservation(String email, int id) {
		customerEmail = email;
		roomID = id;
	}
	
	public String getEmail() {
		return customerEmail;
	}
	
	public int getID() {
		return roomID;
	}
	
	public void setEmail(String email) {
		customerEmail = email;
	}
	
	public void setID(int id) {
		roomID = id;
	}
}