package com.mysite.site1.controllers;


import com.mysite.site1.services.AuthenticationService;
import com.mysite.site1.models.User;
import com.mysite.site1.repository.UserRepository;
import com.mysite.site1.securityModels.AuthenticationRequest;
import com.mysite.site1.securityModels.AuthenticationResponse;
import com.mysite.site1.securityModels.RegisterRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);


    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/getAll")
    private List<User> getAllUsers(){
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
