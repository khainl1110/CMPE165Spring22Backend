package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int roomID; //point to room
	private String userEmail; // point to user's email
	
	public Reservation() {
		
	}
	
	public Reservation(String email, int id) {
		userEmail = email;
		roomID = id;
	}
	
	public String getEmail() {
		return userEmail;
	}
	
	public int getID() {
		return roomID;
	}
	
	public void setEmail(String email) {
		userEmail = email;
	}
	
	public void setID(int id) {
		roomID = id;
	}
}