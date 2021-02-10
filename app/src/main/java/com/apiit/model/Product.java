package com.apiit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;
    @SerializedName("description")
    private String description;
    @SerializedName("category")
    private String category;
    @SerializedName("images")
    private String[] images;
    @SerializedName("item_count")
    private int itemCount;
    @SerializedName("allItems")
    private List<Product> allItems = null;
    @SerializedName("rating")
    private String rating;
    @SerializedName("size")
    private String size;
    @SerializedName("product")
    private Product product;
    @SerializedName("qty")
    private int qty;

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Product> getAllItems() {
        return allItems;
    }

    public List<Product> getAllItems(String category) {
        return allItems;
    }

    public void setAllItems(List<Product> allItems) {
        this.allItems = allItems;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
