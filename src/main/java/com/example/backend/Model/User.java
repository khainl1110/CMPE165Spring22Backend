package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
    private String firstName;
    private String lastName;
    private String password;
    private int points;
    @Id
    private String email;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password, int points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.points = points;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getPoints() {
    	return points;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setPoints(int points) {
    	this.points = points;
    }
}