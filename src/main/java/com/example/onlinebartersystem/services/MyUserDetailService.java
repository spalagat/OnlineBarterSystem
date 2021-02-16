package com.example.onlinebartersystem.services;

import com.example.onlinebartersystem.Entities.User;
import com.example.onlinebartersystem.models.MyUserPrincipal;
import com.example.onlinebartersystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.findUser(s);
        return new MyUserPrincipal(user);
    }
}
