package com.techelevator.models;

// POJO to hold the data coming back from the API

// A POJO has: 	instance variables with names that match the JSON attribute names 
//								so automatic object creation can be done by JSON deserialization
//				a default constructor (sometimes optional)
//				standard getter/setters
//				a toString() method

public class Hotel {

    private int id;
    private String name;
    private int stars;
    private int roomsAvailable;
    private String coverImage;

    public Hotel() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public String getCoverImage() {
        return coverImage;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Hotel Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Name:'" + name + '\'' +
                "\n Stars: " + stars +
                "\n RoomsAvailable: " + roomsAvailable +
                "\n overImage" + coverImage;
    }
}
