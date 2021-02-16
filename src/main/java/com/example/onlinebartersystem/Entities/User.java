package com.example.onlinebartersystem.Entities;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="details_id",referencedColumnName = "id")
    private Details userDetails;

    public User(){

    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

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
