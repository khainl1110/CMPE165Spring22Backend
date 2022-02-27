package com.example.backend.Model;

public class Hotel {
    private String picUrl;
    private String hotelName;
    private String hotelAddress;

    public Hotel(String picUrl, String hotelName, String hotelAddress) {
        this.picUrl = picUrl;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getHotelAddress() {
        return hotelAddress;
    } 

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
