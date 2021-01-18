package com.apiit.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -887225037206150537L;

	private Integer id;
	
	private String categoryType;
	
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
