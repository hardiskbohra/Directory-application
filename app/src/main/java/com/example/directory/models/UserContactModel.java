package com.example.directory.models;

public class UserContactModel {

    private int id;

    private int image;

    private String name;

    private String city;

    private String nativeCity;

    public UserContactModel(int id, int image, String name, String city, String nativeCity) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.city = city;
        this.nativeCity = nativeCity;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getNativeCity() {
        return nativeCity;
    }
}
