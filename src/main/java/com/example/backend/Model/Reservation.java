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
	private long tLong;
	private String tString;

	public Reservation() {
		
	}
	
	public long gettLong() {
		return tLong;
	}

	public void settLong(long tLong) {
		this.tLong = tLong;
	}

	public String gettString() {
		return tString;
	}

	public void settString(String tString) {
		this.tString = tString;
	}

	public Reservation(String email, long id) {
		userEmail = email;
		roomId = id;
	}
	
	// need this so JPA can automatically create id
	public long getId() {
		return id;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	// for some reason long is lowercase?
	public long getroomId() {
		return roomId;
	}
	
	public void setUserEmail(String email) {
		userEmail = email;
	}
	
	public void setroomId(long roomId) {
		this.roomId = roomId;
	}
}