package com.apiit.dto;

import java.io.Serializable;
import java.util.List;

//import com.apiit.shoppingapp.entity.Product;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6539700350037792600L;

	private String username;

	private String userId;

	private String userType;

	private List<ProductDetailsDto> products;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<ProductDetailsDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDetailsDto> products) {
		this.products = products;
	}

}
