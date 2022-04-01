package com.example.backend.RestController;

import java.util.List;

import com.example.backend.Model.Message;
import com.example.backend.Model.Room;
import com.example.backend.Model.cvsDataStore;
import com.example.backend.Model.cvsReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cvsFile")
public class CvsController {

    @Autowired
    cvsDataStore fileCVS;

    @PostMapping("/upload")
    public ResponseEntity<Message> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (cvsReader.hasCSVFormat(file)) {
            try {
                fileCVS.save(file);
                message = "CVS uploaded successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new Message(message));   
            } catch (Exception e) {
                message = "Failed to upload CVS file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Message(message));
            }
        }
        message = "Try to upload CVS file again!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message(message));
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        try {
            List<Room> rooms = fileCVS.getAllRooms();
            if (rooms.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
