package com.example.onlinebartersystem.repositories;

import com.example.onlinebartersystem.Entities.Details;
import com.example.onlinebartersystem.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface UserRepository{
    User findUser(String email);
    User addUser(User user);
    void updateDetails(User user,Details details);
}
