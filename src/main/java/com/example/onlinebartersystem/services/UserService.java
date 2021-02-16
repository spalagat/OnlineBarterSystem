package com.example.onlinebartersystem.services;

import com.example.onlinebartersystem.Entities.Details;
import com.example.onlinebartersystem.Entities.User;
import com.example.onlinebartersystem.models.UserSignUpModel;
import com.example.onlinebartersystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean addUser(UserSignUpModel signUpModel){
        String encodedPassword=passwordEncoder.encode(signUpModel.getPassword());
        User user=userRepository.findUser(signUpModel.getEmail());
        if(user!=null){
            return false;
        }
        user=new User(signUpModel.getEmail(),encodedPassword);
        Details details=new Details(signUpModel.getFirstname(),signUpModel.getLastname(),signUpModel.getPhone1());
        user.setUserDetails(details);
        userRepository.addUser(user);
        return true;
    }

    public User getUser(String email){
        return userRepository.findUser(email);
    }

    @Transactional
    public boolean updateUser(String email,Details details){
        User user=userRepository.findUser(email);
        if(user!=null){
            userRepository.updateDetails(user,details);
            return true;
        }
        return false;
    }
}
