package com.example.backend.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.backend.Repository.RoomRepository;

public class ReadCSVRoom {
	private ArrayList<Room> rooms = new ArrayList<>();
	
	public ReadCSVRoom() throws Exception {
		String file = new File("./src/main/java/com/example/backend/Model/SF_4Adults - Copy.csv").getCanonicalPath();

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        
        /*
         * (String hotelName, String location, String image, 
         * double rating, String description, String amenities, 
         * String roomInfo, int price, int numGuest, boolean isBooked)
         */
        
        ArrayList<Room> rooms = new ArrayList<>();
        
        // skip the first headline
        br.readLine();
        String str;
        
        while((str = br.readLine()) != null) {
        	
        
	        String[] split = str.split(",");

	
	        //System.out.println(split.length + " " + split[0]);
	       	String hotelName = split[0];
	       	String location = split[2];
	       	String image = split[1];
	       	double rating = 9.8;
	       	// sometimes don't have split 14
	       	String description = "hotel description";
	       	if (split.length > 14)
	       		description = split[14];
	       	
	       	// amenities is add_info1
	       	String amenities = split[7] + " " + split[8] + " " + split[9];
	       	
	       	// sometimes don't have split 13
	       	String roomInfo = "This is room info";
	       	if (split.length > 13)
	       		roomInfo = split[13];
	       
	       	// first need to check whether the length is more than 0
	       	int price = 101;
	       	if (split[11].length() > 0) {
	       		// need to remove space after it
		       	price = Integer.parseInt( split[11].substring(1, split[11].length()-1) );
	       	}
	       	
	       	int numGuest = 4;
	       	boolean isBooked = false;
	       	
	       	Room room = new Room(hotelName, location, image, rating, 
	       			description, amenities, roomInfo,
	       			price, numGuest,isBooked);
	       	rooms.add(room);

            
    	}
        System.out.println("After reading " + rooms.size());
        for (int i = 0; i < rooms.size(); i++) {
        	System.out.println( rooms.get(i) );
        }
        // while ( (st = br.readLine()) != null) {

        //     System.out.println(st);
        //     System.out.println();
        // }
        
       
    	
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}

}
