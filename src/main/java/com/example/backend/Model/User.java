package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
<<<<<<< HEAD:src/main/java/com/example/backend/Model/User.java
	
=======
>>>>>>> abba5a3257baa01201b85cb24a6cc7e98948737b:src/main/java/com/example/backend/Model/Customer.java
    private String username;
    private String password;
    private String email;

    public User() {

    }

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
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