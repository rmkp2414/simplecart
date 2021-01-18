package com.apiit.dto;

import java.io.Serializable;

public class ResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5586705663388855772L;

	private Boolean status;
	
	private String statusMessage;
	
	private Object data;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
