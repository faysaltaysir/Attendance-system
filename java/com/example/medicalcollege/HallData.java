package com.example.medicalcollege;

public class HallData {
    private String name;
    private String contact;
    private String rooms;
    private String location;

    public HallData(String name, String contact, String  rooms, String location) {
        this.name = name;
        this.contact = contact;
        this.rooms = rooms;
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public String getContact() {
        return contact;
    }
    public String getRooms() { return rooms; }
    public String getLocation() { return location; }

    public void setName(String name) {
        this.name = name;}
    public void setContact(String contact) { this.contact = contact;}
    public void setRooms(String rooms) { this.rooms = rooms;}
    public void setLocation(String location) { this.location = location;}

}
