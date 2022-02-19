package com.example.backend.RestController;

import com.example.backend.Model.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class TestController {
    
    @GetMapping("/")
    public User getMapping() {
        return new User("matthew", "hello");
    }
}
