package com.example.backend.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class cvsReader {
    public static String TYPE = "text/cvs";
    static String[] HEADERS = { "hotelName", "image", "location", "rating", "description", "price", "isBooked" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    // read and return all the rooms in the input stream?
    /*
     * Room attribute
     * this.hotelName = hotelName;
		this.location = location;
		this.image = image;
		this.rating = rating;
		this.description = description;
		this.price = price;
		this.isBooked = isBooked;
		
		Room(String hotelName, String location, String image, double rating, String description, int price, boolean isBooked) 
     */
    public static List<Room> csvRoom(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Room> rooms = new ArrayList<Room>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Room room = new Room(csvRecord.get("Title"),
                        csvRecord.get("Address"), csvRecord.get("Image"), Double.parseDouble( csvRecord.get("rating") ),
                        csvRecord.get("Description"), Integer.parseInt(csvRecord.get("price")),false );
                rooms.add(room);
            }
            return rooms;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<Room> cvsRooms(InputStream inputStream) {
        return null;
    }
}
