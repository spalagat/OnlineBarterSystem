package com.example.onlinebartersystem.Exceptions;

public class DuplicateUserRecordException extends RuntimeException {
    private String message;

    public DuplicateUserRecordException(String message) {
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
