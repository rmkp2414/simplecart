package com.apiit.api;

import com.google.gson.annotations.SerializedName;

public class GeneralResponse {

    @SerializedName("success")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
