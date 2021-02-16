package com.example.onlinebartersystem.controllers;

import com.example.onlinebartersystem.models.AuthenticateRequestModel;
import com.example.onlinebartersystem.models.AuthenticationResponseModel;
import com.example.onlinebartersystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HomeController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil util;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseModel> authenticate(@Valid @RequestBody AuthenticateRequestModel requestModel) throws BadCredentialsException{
        System.out.println("Inside authenticate method");
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestModel.getEmail(),requestModel.getPassword()));
        }
        catch(BadCredentialsException e){
            throw e;
        }
        final String jwtToken= util.generateToken(userDetailsService.loadUserByUsername(requestModel.getEmail()));
        System.out.println("jwt token "+jwtToken);
        return ResponseEntity.ok(new AuthenticationResponseModel(jwtToken));
    }



}
