package com.example.backend.Model;

public class User {
    private String username;
    private String password;
    private String email;

    public User() {

    }

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public boolean equals(User user) {
    	if (this.username.equals(user.getUsername())) {
    		return true;
    	}
    	else if (this.email.equals(user.getEmail())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
