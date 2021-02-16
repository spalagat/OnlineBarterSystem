package com.example.onlinebartersystem.models;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionResponseModel {

    private HttpStatus statuscode;

    private String message;

    private String date;

    public ExceptionResponseModel(HttpStatus statuscode, String message, String date) {
        this.statuscode = statuscode;
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HttpStatus getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(HttpStatus statuscode) {
        this.statuscode = statuscode;
    }
}
