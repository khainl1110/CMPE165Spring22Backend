package com.example.backend.Model;

import java.util.ArrayList;

public class LoadRoom {
	private static ArrayList<Room> rooms = new ArrayList<>();

	public LoadRoom() {
    	/*
    	 * 	manually load room data
    	 * 	private String hotelName;
			private String image;
			private double rating; //1-10 stars
			private String description;
			private int price;
			private boolean isBooked;
	
			Room(String hotelName, String image, int rating, String description, int price, boolean isBooked)
    	 */
    	Room room1 = new Room("Handlery Union Square Hotel", "Union Square, San Francisco",
    						"https://t-cf.bstatic.com/xdata/images/hotel/square200/77849034.webp?k=cc064fd4766234f7d019c24f12739f32fe8109a7376e5dbcab31f0ab3b255615&o=&s=1",
    						8.3, "description here", "amenities here", "Double Room with Two Double Beds", 319, 2, false);
    	rooms.add(room1);
    	
    	room1 = new Room("Greenwich Inn", "Marina District, San Francisco",
    					"https://t-cf.bstatic.com/xdata/images/hotel/square200/66019928.webp?k=79fd6333cb5083b0fa55eb6837135370225417cfb00144912e64bbe51c3c9831&o=&s=1",
    					8, "description here", "amenities here", "Premium Two Full Beds", 159, 3, false);
    	rooms.add(room1);
    	
    	room1 = new Room("Club Quarters Hotel Embarcadero, San Francisco", "Financial District, San Francisco",
    					"https://t-cf.bstatic.com/xdata/images/hotel/square200/280948488.webp?k=fada4f491f9602c4cbea7a621489319ee9f02e1af55328affd76619053ff6c78&o=&s=1",
    					8.2, "description here", "amenities here", "Superior Queen Room", 249, 4, false);
    	rooms.add(room1);
    	
    	room1 = new Room("Hampton Inn San Francisco Downtown/Convention Center", "Downtown San Francisco, San Francisco",
    					"https://t-cf.bstatic.com/xdata/images/hotel/square200/55282779.webp?k=2a790e39e42f9568c4e6e42b8b77256652da9366a3d0c58607db629f997b6044&o=&s=1",
    					7.9, "description here", "amenities here", "Deluxe King Room with Sofa Bed", 339, 1, false);
    	rooms.add(room1);
    	
    	room1 = new Room("Riu Plaza Fisherman's Wharf", "Fisherman's Wharf, San Francisco",
    					"https://t-cf.bstatic.com/xdata/images/hotel/square200/228751512.webp?k=67a0f2c6411b98fa3923a695f9510dcc1092e3c0f90b3feb7f9d1cd807100bb9&o=&s=1",
    					8.1, "description here", "amenities here", "Deluxe Queen Room with Two Queen Beds", 329, 5, false);
    	rooms.add(room1);
    	
    	room1 = new Room("Riu Plaza Fisherman's Wharf", "Fisherman's Wharf, San Francisco",
				"https://t-cf.bstatic.com/xdata/images/hotel/square200/228751512.webp?k=67a0f2c6411b98fa3923a695f9510dcc1092e3c0f90b3feb7f9d1cd807100bb9&o=&s=1",
				8.1, "description here", "amenities here", "Deluxe Queen Room with Two Queen Beds", 329, 5, false);
    	rooms.add(room1);
    	
    	room1 = new Room("Riu Plaza Fisherman's Wharf", "Fisherman's Wharf, San Francisco",
				"https://t-cf.bstatic.com/xdata/images/hotel/square200/228751512.webp?k=67a0f2c6411b98fa3923a695f9510dcc1092e3c0f90b3feb7f9d1cd807100bb9&o=&s=1",
				8.1, "description here", "amenities here", "Deluxe Queen Room with Two Queen Beds", 329, 5, false);
    	rooms.add(room1);
    	
	}
	
	public static ArrayList<Room> getRooms() {
		return rooms;
	}

	
	
}
