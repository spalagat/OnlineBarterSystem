package com.example.onlinebartersystem.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class AuthenticateRequestModel {
    @NotBlank(message="Email should not be empty")
    private String email;

    @NotBlank(message = "Password should not be empty")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
