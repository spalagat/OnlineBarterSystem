package com.example.onlinebartersystem.controllers;

import com.example.onlinebartersystem.Entities.Details;
import com.example.onlinebartersystem.Entities.User;
import com.example.onlinebartersystem.Exceptions.DuplicateUserRecordException;
import com.example.onlinebartersystem.Exceptions.UserNameNotFoundException;
import com.example.onlinebartersystem.models.UserSignUpModel;
import com.example.onlinebartersystem.models.GenericResponseModel;
import com.example.onlinebartersystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.* ;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CacheConfig(cacheNames={"users"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        System.err.println("Error is error ");
        return "Welcome to the main page";
    }

    @GetMapping("/get/{email}")
    @CacheEvict(value = "users",allEntries = true)
    public User getUser(@RequestHeader("Content-Type") String accept,@PathVariable String email){
        System.out.println(accept);
        return userService.getUser(email);
    }

    @PostMapping("/post/signup")
    public ResponseEntity<GenericResponseModel> signUp(@Valid  @RequestBody UserSignUpModel signUpModel) {
        if(!userService.addUser(signUpModel)){
            throw new DuplicateUserRecordException("User Already exists");
        }
        return ResponseEntity.ok(new GenericResponseModel("Succesfully added the user"));
    }

    @PutMapping("/update/details")
    public ResponseEntity<GenericResponseModel> update(@Valid @RequestBody Details details){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        if(!userService.updateUser(email,details)){
            throw new UserNameNotFoundException("Cannot find the user with email "+email);
        }
        return ResponseEntity.ok(new GenericResponseModel("Details are updated succesfully"));
    }
}
