package com.example.garageapp;

public class Model {

    String name;
    String year;
    String price;
    String description;
    int image;



    public Model(String name, String year, String price, int image, String description) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getYear(){ return year; }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
    public String getDescription(){ return description; }

}


