package com.example.backend.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.backend.Model.User;

public interface UserRepository extends CrudRepository<User, Long>{
    // find by username, capitalize first letter
	User findByUsername(String username);
}
