package com.mysite.site1.controllers;

import com.mysite.site1.models.SingleContent;
import com.mysite.site1.models.Star;
import com.mysite.site1.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/stars")
public class StarController {

    @Autowired
    StarRepository starRepository;


    @GetMapping("/getAll")
    public ResponseEntity<List<Star>> getAllContents(){
        return ResponseEntity.ok(starRepository.findAll());
    }

    @DeleteMapping("/deleteAll")
    public void deleteContents(){
        starRepository.deleteAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContent (@RequestBody Star star){
        starRepository.save(star);
        return ResponseEntity.ok("Star" +  star.getName() +" added!");
    }
}
