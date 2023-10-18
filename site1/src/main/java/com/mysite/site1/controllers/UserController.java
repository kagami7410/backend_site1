package com.mysite.site1.controllers;


import com.mysite.site1.models.User;
import com.mysite.site1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/users/getAll")
    private List<User> getAllUsers(){
        return userRepository.findAll();
    }



}
