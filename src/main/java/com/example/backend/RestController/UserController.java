package com.example.backend.RestController;

import com.example.backend.Model.User;
import com.example.backend.Repository.UserRepository;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	/*
	
	@Autowired
	UserRepository repo;
	
	@GetMapping("")
    public Iterable<User> getMapping() {
        return repo.findAll();
    }
   
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		Optional<User> data = repo.findById(id);
		return data.get();
	}

	// create new user
    @PostMapping()
    public User registerUser(@RequestBody User user) {
    	// first need to check whether there's existing username or not
    	User temp = repo.findByUsername(user.getUsername());
    	// will look into how to return http code instead
    	// but for now will return the same user
    	if(temp != null)
    		return temp;
    	else {
    		repo.save(user);
        	return user;
    	}	
    	
    }
    
    // find user by username
    // guide: https://stackoverflow.com/questions/27066437/how-to-see-result-of-findbyusername-delievered-by-crudrepository
    @GetMapping("/find")
    public User findByUsername(@RequestParam("username") String username) {
    	return repo.findByUsername(username);
    }
    
    // update existing user
    @PutMapping()
    public User updateRegister(@RequestBody User updatedUser) {
    	Optional<User> data = repo.findById(updatedUser.getId());
    	User user = data.get();
    	user.setUsername(updatedUser.getUsername());
    	user.setPassword(updatedUser.getPassword());
    	user.setEmail(updatedUser.getEmail());
    	
    	return repo.save(user);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
    	repo.deleteById(id);
    	return "delete";
    }
    */
    
}