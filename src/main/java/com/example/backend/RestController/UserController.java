package com.example.backend.RestController;

import com.example.backend.Model.Message;
import com.example.backend.Model.Payment;
import com.example.backend.Model.User;
import com.example.backend.Repository.UserRepository;
import java.util.*;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@PostConstruct
	public void addUsers() {
		// String firstName, String lastName, String email, String password
		repo.save(new User("John", "Doe", 
				"johndoe@gmail.com", "johndoe"));
		repo.save(new User("Kenny", "Potter", "kenny@gmail.com", "password123"));
	}
	
	@GetMapping("")
    public Iterable<User> getMapping() {
        return repo.findAll();
    }
   
	// id here is email
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") String id) {
		Optional<User> data = repo.findById(id);
		return data.get();
	}

	// create new user
    @PostMapping()
    public User registerUser(@RequestBody User user) {
    	return repo.save(user);
    	
    }
    
    // update existing user
    @PutMapping()
    public User updateUser(@RequestBody User updatedUser) {
    	Optional<User> data = repo.findById(updatedUser.getEmail());
    	
    	User user = data.get();

    	user.setFirstName(updatedUser.getFirstName());
    	user.setLastName(updatedUser.getLastName());
    	user.setPassword(updatedUser.getPassword());
    	user.setPoints(updatedUser.getPoints());
    	user.setPaymentId(updatedUser.getPaymentId());
    	
    	return repo.save(user);
    }
    
    @DeleteMapping("/{id}")
    public Message deleteUser(@PathVariable("id") String id) {
    	repo.deleteById(id);
    	return new Message("User deleted");
    }
    
}