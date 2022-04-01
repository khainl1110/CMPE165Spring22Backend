package com.example.backend.Model;

import java.io.IOException;
import java.util.List;

import com.example.backend.Repository.cvsFileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class cvsDataStore {

    @Autowired
    cvsFileRepository repository;

    //save(MultipartFile): store CVS data to database
    public void save(MultipartFile file) {
        try {
            List<Room> rooms = cvsReader.cvsRooms(file.getInputStream());
            repository.saveAll(rooms);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }  

    //getAllRooms():read data from database and return List<Room>
    public List<Room> getAllRooms() {
        return repository.findAll();
    }
}
