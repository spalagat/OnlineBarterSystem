package com.example.onlinebartersystem.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="details")
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    @NotBlank(message="First Name is Required")
    private String firstName;

    @NotBlank(message="Last Name is Required")
    @Column(name="lastname")
    private String lastName;

    @NotBlank(message="Atleast One Phone No is Requrired")
    @Column(name="phone1")
    private String phone1;

    @Column(name="phone2")
    private String phone2;

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    //private User user;

    public Details(String firstName, String lastName, String phone1) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone1 = phone1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public Details() {
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }


}
