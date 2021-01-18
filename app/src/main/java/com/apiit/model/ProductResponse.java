package com.apiit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResponse {



    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("year")
    private String year;
    @SerializedName("color")
    private String color;
    @SerializedName("pantone_value")
    private String pantone_value;


    @SerializedName("image")
    private String image;
    @SerializedName("rating")
    private int rating;
    @SerializedName("calory")
    private int calory;
    @SerializedName("fat")
    private int fat;
    @SerializedName("sodium")
    private int sodium;
    @SerializedName("protein")
    private int protein;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getYear() {
        return year;
    }

//    public void setPrice(double price) {
//        this.price = price;
//    }

    public String getColor() {
        return color;
    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public String getPantone_value() {
        return pantone_value;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}
