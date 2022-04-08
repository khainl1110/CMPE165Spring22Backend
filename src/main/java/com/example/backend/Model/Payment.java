package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Payment {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long payment_id;
	
	private String customerName;
	private String cardNum;
	private int cvcCode;
	private LocalDate expiration;
	
	public Payment() {
		
	}
	
	public Payment(String customerName, String cardNum, int cvcCode, LocalDate expiration) {
		this.customerName = customerName;
		this.cardNum = cardNum;
		this.cvcCode = cvcCode;
		this.expiration = expiration;
	}
	
	public String getCustomer() {
		return customerName;
	}
	
	public String getCardNum() {
		return cardNum;
	}
	
	public int getCode() {
		return cvcCode;
	}
	
	public LocalDate getExpiration() {
		return expiration;
	}
	
	public void setCustomer(String customerName) {
		this.customerName = customerName;
	}
	
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	public void setCode(int cvcCode) {
		this.cvcCode = cvcCode;
	}
	
	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}
}