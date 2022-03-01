package com.example.backend.RestController;

import com.example.backend.Model.User;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	private ArrayList<User> tempStorage = new ArrayList<>();
	
    @GetMapping("/display")
    public List<User> getMapping() {
        return tempStorage;
    }
   
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@RequestBody User newUser) {
    	for (User u: tempStorage) {
    		if (u.equals(newUser)) {
    			return "Username exists already, please try again.";
    		}
    	}
    	tempStorage.add(newUser);
    	return "User created.";
    }
}
