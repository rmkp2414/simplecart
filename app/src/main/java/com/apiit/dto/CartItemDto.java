package com.apiit.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -79582017275410505L;

	private int id;
	
	private int quantity;
	
	private double soldPrice;
	
	private String size;
	
	private String image;
	
	private String productName;
	
	private int productId;
	
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	private String category;

	public String getCategomry() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CartItemDto(int id, int quantity, double soldPrice, String size, String image, String productName, int productId, double total) {
		this.id = id;
		this.quantity = quantity;
		this.soldPrice = soldPrice;
		this.size = size;
		this.image = image;
		this.productName = productName;
		this.productId = productId;
		this.total = total;

	}

	public CartItemDto(double soldPrice, String size, String image, String productName, int productId,String category) {
		this.soldPrice = soldPrice;
		this.size = size;
		this.image = image;
		this.productName = productName;
		this.productId = productId;
		this.category = category;
	}


}
