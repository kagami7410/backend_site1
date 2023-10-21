package com.mysite.site1.controllers;


import com.mysite.site1.config.services.AuthenticationService;
import com.mysite.site1.models.User;
import com.mysite.site1.repository.UserRepository;
import com.mysite.site1.securityModels.AuthenticationRequest;
import com.mysite.site1.securityModels.AuthenticationResponse;
import com.mysite.site1.securityModels.RegisterRequest;
import org.example.maths.MyMath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;


    @GetMapping("/users/getAll")
    private List<User> getAllUsers(){
        MyMath myMath = new MyMath();
        myMath.adAddition(3,8);
        return userRepository.findAll();
    }

    @PostMapping("/register")
    private ResponseEntity<AuthenticationResponse> addUser(
            @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        logger.info("Autenticating...");
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }



}
