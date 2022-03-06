package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;

    public User() {

    }

    public User(String username, int userID, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
    	return this.id;
    }
    
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
    	this.id = id;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
}