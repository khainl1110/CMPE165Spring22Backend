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
	
	public ReadCSVRoom() {
		
       
    	
	}
	
	public ArrayList<Room> getRooms() throws Exception{
		
		String file = new File("./src/main/java/com/example/backend/Model/SF_4Adults.csv").getCanonicalPath();

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

	
	        //System.out.println(split.length + " " + split[0] + " " + split[split.length-1]);
	       	String hotelName = split[0];
	       	String location = split[3] + ", San Francisco";
	       	String image = split[1];
	       	// need to check if there's no rating
	       	double rating = 9.0;
	       	if (split[6].length() > 1)
	       		rating = Double.parseDouble( split[6] );
	       	
	       	// sometimes don't have split 14
	       	String description = "hotel description";
	       	if (split.length > 15)
	       		description = split[15];
	       	
	       	// amenities is add_info1
	       	String amenities = split[8] + " " + split[9] + " " + split[10] + " " + split[11];
	       	
	       	// sometimes don't have split 14
	       	String roomInfo = "This is room info";
	       	if (split.length > 14)
	       		roomInfo = split[14];
	       
	       	// first need to check whether the length is more than 0
	       	int price = 101;
	       	if (split[12].length() > 0) {
	       		// need to remove space after it
		       	price = Integer.parseInt( split[12].substring(1, split[12].length()-1) );
	       	}
	       	
	       	int numGuest = 4;
	       	boolean isBooked = false;
	       	
	       	Room room = new Room(hotelName, location, image, rating, 
	       			description, amenities, roomInfo,
	       			price, numGuest,isBooked);
	       	rooms.add(room);
	        
            
    	}
        
//        for (int i = 0; i < rooms.size(); i++) {
//        	System.out.println( rooms.get(i) );
//        }
        // while ( (st = br.readLine()) != null) {

        //     System.out.println(st);
        //     System.out.println();
        // }
        
		return rooms;
	}

}
