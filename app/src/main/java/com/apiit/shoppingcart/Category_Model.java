package com.apiit.shoppingcart;

public class Category_Model {

    private int CategoryIconLink;
    private String categoryname;

    public Category_Model(int categoryIconLink, String categoryname) {
        this.CategoryIconLink = categoryIconLink;
        this.categoryname = categoryname;
    }

    public int getCategoryIconLink() {
        return CategoryIconLink;
    }

    public void setCategoryIconLink(int categoryIconLink) {
        CategoryIconLink = categoryIconLink;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
