package com.example.onlinebartersystem.Exceptions;

public class UserNameNotFoundException extends RuntimeException {
    private String message;

    public UserNameNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
