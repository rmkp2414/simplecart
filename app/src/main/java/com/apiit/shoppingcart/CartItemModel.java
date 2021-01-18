package com.apiit.shoppingcart;

public class CartItemModel {

    public static final int CART_ITEM = 0;
    public static final int TOTAL_AMOUNT = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //////////Cart Item//////////

    private int productImage;
    private String productTitle;
    private int freecoupens;
    private String ProdcuPrice;
    private String cuttedPrice;
    private int productQuntity;
    private int offerApplied;
    private int coupenApplied;

    public CartItemModel(int type, int productImage, String productTitle, int freecoupens, String prodcuPrice, String cuttedPrice, int productQuntity, int offerApplied, int coupenApplied) {
        this.type = type;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freecoupens = freecoupens;
        ProdcuPrice = prodcuPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQuntity = productQuntity;
        this.offerApplied = offerApplied;
        this.coupenApplied = coupenApplied;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreecoupens() {
        return freecoupens;
    }

    public void setFreecoupens(int freecoupens) {
        this.freecoupens = freecoupens;
    }

    public String getProdcuPrice() {
        return ProdcuPrice;
    }

    public void setProdcuPrice(String prodcuPrice) {
        ProdcuPrice = prodcuPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductQuntity() {
        return productQuntity;
    }

    public void setProductQuntity(int productQuntity) {
        this.productQuntity = productQuntity;
    }

    public int getOfferApplied() {
        return offerApplied;
    }

    public void setOfferApplied(int offerApplied) {
        this.offerApplied = offerApplied;
    }

    public int getCoupenApplied() {
        return coupenApplied;
    }

    public void setCoupenApplied(int coupenApplied) {
        this.coupenApplied = coupenApplied;
    }

    //////////Cart Item//////////


    //////////Cart Total/////////

    private String totalItems;
    private String totalItemPrice;
    private String deleveryPrice;
    private String saveAmount;
    private String totalAmount;

    public CartItemModel(int type, String totalItems, String totalItemPrice, String deleveryPrice, String saveAmount, String totalAmount) {
        this.type = type;
        this.totalItems = totalItems;
        this.totalItemPrice = totalItemPrice;
        this.deleveryPrice = deleveryPrice;
        this.saveAmount = saveAmount;
        this.totalAmount = totalAmount;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public String getDeleveryPrice() {
        return deleveryPrice;
    }

    public void setDeleveryPrice(String deleveryPrice) {
        this.deleveryPrice = deleveryPrice;
    }

    public String getSaveAmount() {
        return saveAmount;
    }

    public void setSaveAmount(String saveAmount) {
        this.saveAmount = saveAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
