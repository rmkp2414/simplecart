package com.apiit.model;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    private static final long serialVersionUID = -5586705663388855772L;

    @SerializedName("status")
    private Boolean status;
    @SerializedName("statusMessage")
    private String statusMessage;
    @SerializedName("data")
    private Object data;

    public Boolean getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
