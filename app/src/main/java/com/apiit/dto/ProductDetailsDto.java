package com.apiit.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ProductDetailsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4580174486300298545L;

	private String id;
	
	private String name;
	
	private String description;
	
	private String category;
	
	private Integer categoryId;
	
	private List<String> images;
	
	private String price;
	
	private String priceWithoutFraction;
	
	private String priceFraction;
	
	private Map<String, Boolean> sizes;
		
	private String rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Map<String, Boolean> getSizes() {
		return sizes;
	}

	public void setSizes(Map<String, Boolean> sizes) {
		this.sizes = sizes;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPriceWithoutFraction() {
		return priceWithoutFraction;
	}

	public void setPriceWithoutFraction(String priceWithoutFraction) {
		this.priceWithoutFraction = priceWithoutFraction;
	}

	public String getPriceFraction() {
		return priceFraction;
	}

	public void setPriceFraction(String priceFraction) {
		this.priceFraction = priceFraction;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
}
