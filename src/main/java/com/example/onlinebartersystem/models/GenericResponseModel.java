package com.example.onlinebartersystem.models;

public class GenericResponseModel {

    private String message;

    public GenericResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
