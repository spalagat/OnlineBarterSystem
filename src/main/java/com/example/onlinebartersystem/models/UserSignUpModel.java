package com.example.onlinebartersystem.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserSignUpModel {

    @NotBlank(message="Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "First Name is Required")
    private String firstname;

    @NotBlank(message = "LastName is Required")
    private String lastname;

    @NotBlank(message = "Atleast One Phone number is required")
    private String phone1;

    private String phone2;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }


}
