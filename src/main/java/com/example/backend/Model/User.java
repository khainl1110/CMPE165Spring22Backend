package com.example.backend.Model;

public class User {
    private String username;
    private int userID;
    private String password;
    private String email;

    public User() {

    }

    public User(String username, int userID, String email, String password) {
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.email = email;
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
    
    public int getID() {
    	return userID;
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
    
    public void setID(int id) {
    	this.userID = id;
    }
    
    public void update(User updatedUser) {
    	if (updatedUser.getEmail() != null) {
    		this.email = updatedUser.getEmail();
    	}
    	
    	if (updatedUser.getUsername() != null) {
    		this.username = updatedUser.getUsername();
    	}
    	
    	if (updatedUser.getPassword() != null) {
    		this.password = updatedUser.getPassword();
    	}
    }
    
    public boolean equals(User user) {
    	if (this.username.equals(user.getUsername())) {
    		return true;
    	}
    	else if (this.email.equals(user.getEmail())) {
    		return true;
    	}
    	else if (this.userID == user.getID()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}