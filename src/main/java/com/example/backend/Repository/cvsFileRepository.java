package com.example.backend.Repository;

import com.example.backend.Model.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cvsFileRepository extends JpaRepository<Room, String> {

    
}
