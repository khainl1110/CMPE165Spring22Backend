package com.example.backend.RestController;

import com.example.backend.Model.User;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	private ArrayList<User> tempStorage = new ArrayList<>();
	
	@GetMapping("")
    public List<User> getMapping() {
        return tempStorage;
    }
   
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User newUser, @PathVariable("id") int id) {
    	for (User u: tempStorage) {
    		if (u.equals(newUser)) {
    			return null;
    		}
    	}
    	newUser.setID(id);
    	tempStorage.add(newUser);
    	return newUser;
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteUser(@PathVariable("id") int id) {
    	for (int i = 0; i < tempStorage.size(); i ++) {
    		if (tempStorage.get(i).getID() == id) {
    			tempStorage.remove(i);
    			return HttpStatus.OK;
    		}
    	}
    	return HttpStatus.PRECONDITION_FAILED;
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateRegister(@RequestBody User updatedUser, @PathVariable("id") int id) {
    	//just in case they are being sneaky and try to change email or username to a prexisting user
    	for (User u: tempStorage) {
    		if (u.getEmail().equals(updatedUser.getEmail()) || u.getUsername().equals(updatedUser.getUsername())) {
    			return null;
    		}
    	}
    	
    	for (int i = 0; i < tempStorage.size(); i ++) {
    		if (tempStorage.get(i).getID() == id) {
    			tempStorage.get(i).update(updatedUser);
    			return tempStorage.get(i);
    		}
    	}
    	return null;
    }
}