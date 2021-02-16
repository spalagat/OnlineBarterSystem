package com.example.onlinebartersystem.repositories;

import com.example.onlinebartersystem.Entities.Details;
import com.example.onlinebartersystem.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private EntityManager entityManager;

    @Override
    public User findUser(String email) {
        Session session=entityManager.unwrap(Session.class);
        User user=session.get(User.class,email);
        return user;
    }

    @Override
    public User addUser(User user) {
        Session session=entityManager.unwrap(Session.class);
        session.save(user);
        return user;
    }

    @Override
    public void updateDetails(User user,Details details) {
        Session session=entityManager.unwrap(Session.class);
        user.setUserDetails(details);
        session.save(user);
    }
}
