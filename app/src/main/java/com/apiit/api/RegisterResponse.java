package com.apiit.api;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
//    private int Id;
//    private String email;
//    private String username;
//    public int getId() {
//        return Id;
//    }
//    public void setId(int id) {
//        Id = id;
//    }
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    public String getUsername() {
//        return username;
//    }
//    public void setUsername(String username) {
//        this.username = username;
//    }

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
