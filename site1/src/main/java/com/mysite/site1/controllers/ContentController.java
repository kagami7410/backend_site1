package com.mysite.site1.controllers;

import com.mysite.site1.models.SingleContent;
import com.mysite.site1.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {

    @Autowired
    ContentRepository contentRepository;


    @GetMapping("/getAll")
    public ResponseEntity<List<SingleContent>> getAllContents(){
        return ResponseEntity.ok(contentRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContent (@RequestBody SingleContent singleContent){
        contentRepository.save(singleContent);
        return ResponseEntity.ok("Content added!");
    }
}
