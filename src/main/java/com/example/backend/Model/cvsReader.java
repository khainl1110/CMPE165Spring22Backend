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

    public static List<Room> csvRoom(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Room> rooms = new ArrayList<Room>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Room room = new Room(Long.parseLong(csvRecord.get("id")), csvRecord.get("hotelName"),
                        csvRecord.get("image"), csvRecord.get("location"), csvRecord.get("description"),
                        csvRecord.get("price"), Boolean.parseBoolean(csvRecord.get("isBooked")));
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
