package com.apiit.entities;

public class ProductItemPIcture {
	
    private int id;
    
    private String Picture;
    
    private String path;
    
    private Product productItemId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Product getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(Product productItemId) {
		this.productItemId = productItemId;
	}

}
