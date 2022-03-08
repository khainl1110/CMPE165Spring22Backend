package com.example.backend.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class City {
	private double lat;
	private double lon;
	private String name;
	
	private static ArrayList<City> list = new ArrayList<>(
			Arrays.asList(new City("Barcelona", 41.346176, 2.168365),
				new City("Tokyo", 35.710064, 139.810699),
				new City("Osaka", 34.672314, 135.484802),
				new City("San Jose", 37.335480, -121.893028),
				new City("New York City", 40.730610, -73.935242)));
	
	public City() { 
		//empty constructor
	}
	
	public City(String name, double lat, double lon) {
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}
	
	public String getCityName() {
		return name;
	}
	
	public double getLatitude() {
		return lat;
	}
	
	public double getLongitude() {
		return lon;
	}
	
	public void setCityName(String name) {
		this.name = name;
	}
	
	public void setLatitude(double lat) {
		this.lat = lat;
	}
	
	public void setLongitude(double lon) {
		this.lon = lon;
	}
	
	public static City findNearest(double lat, double lon) {
		double min = Double.MAX_VALUE;
		City minCity = null;
		
		for (City c: list) {
			double dist = haversineDistance(lat, lon, c.getLatitude(), c.getLongitude());
			if (dist < min) {
				min = dist;
				minCity = c;
			}
		}
		return minCity;
	}
	
	private static double haversineDistance(double fromLat, double fromLon, double lat, double lon) {
		double distLat = Math.toRadians(lat - fromLat);
		double distLon = Math.toRadians(lon - fromLon);
		double radiusEarth = 6371;
		
		double fromLatRad = Math.toRadians(fromLat);
		double latRad = Math.toRadians(lat);
		
		double distance = Math.pow(Math.sin(distLat) / 2, 2) + 
				Math.cos(fromLatRad) * 
				Math.cos(latRad) * 
				Math.pow(Math.sin(distLon) / 2, 2);
		return 2 * radiusEarth * Math.asin(distance);
	}
}