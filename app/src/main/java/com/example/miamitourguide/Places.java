package com.example.miamitourguide;

public class Places {
    private String name;
    private String phone;
    private String address;
    private int imgResourceId;
    private String placeSummary;

    public Places(String name, String phone, String address, int imageResourceId) {
        this.name =  name;
        this.phone = phone;
        this.address = address;
        this.imgResourceId = imageResourceId;
    }

    public Places(String name, String phone, String address, int imageResourceId, String placeSummary) {
        this.name =  name;
        this.phone = phone;
        this.address = address;
        this.imgResourceId = imageResourceId;
        this.placeSummary = placeSummary;
    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public String getPlaceSummary() {
        return placeSummary;
    }
}
