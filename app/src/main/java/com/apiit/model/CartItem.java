package com.apiit.model;

import com.google.gson.annotations.SerializedName;

public class CartItem {


    private static final long serialVersionUID = -79582017275410505L;

    @SerializedName("id")
    private int id;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("soldPrice")
    private double soldPrice;
    @SerializedName("size")
    private String size;
    @SerializedName("image")
    private String image;
    @SerializedName("productName")
    private String productName;
    @SerializedName("productId")
    private int productId;
    @SerializedName("total")
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
