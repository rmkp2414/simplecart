package com.apiit.model;

import com.google.gson.annotations.SerializedName;

public class GeneralResponse {

    @SerializedName("success")
    private String message;

    @SerializedName("status")
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
