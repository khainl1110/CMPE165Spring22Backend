package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Payment {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String number;
	private int cvcCode;
	private String expiration;
	
	public Payment() {
		
	}
	
	public Payment(String name, String number, int cvcCode, String expiration) {
		this.name = name;
		this.number = number;
		this.cvcCode = cvcCode;
		this.expiration = expiration;
	}
	
	// need this so JPA can automatically create id
	public long getId() {
		return id;
	}
		
	public int getCvcCode() {
		return cvcCode;
	}

	public void setCvcCode(int cvcCode) {
		this.cvcCode = cvcCode;
	}

	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getExpiration() {
		return expiration;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
}