package com.mysite.site1.controllers;

import com.mysite.site1.models.Advertisement;
import com.mysite.site1.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    AdvertisementRepository advertisementRepository;

    @GetMapping("/getAll")
    ResponseEntity<List<Advertisement>> getAllAdvertisement(){
        return ResponseEntity.ok(advertisementRepository.findAll());
    }


    @PostMapping("/add")
    ResponseEntity<String> addAdvertisement(
            @RequestBody Advertisement advertisement
    ){
        advertisementRepository.save(advertisement);
        return ResponseEntity.ok("advertisment " + advertisement.getName() + " added!");
    }

    @DeleteMapping("/deleteAll")
    ResponseEntity<String> deleteAllAdvertisement(){
        advertisementRepository.deleteAll();
        return ResponseEntity.ok("advertisments  deleted!");
    }



}
