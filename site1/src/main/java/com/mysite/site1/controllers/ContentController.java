package com.mysite.site1.controllers;

import com.mysite.site1.error.ContentNotReturnedException;
import com.mysite.site1.models.SingleContent;
import com.mysite.site1.repository.ContentRepository;
import com.mysite.site1.services.impl.ContentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ContentRepository contentRepository;

    @Autowired private ContentServiceImpl contentService;


    @GetMapping("/getAll")
    public ResponseEntity<List<SingleContent>> getAllContents(){
        List<SingleContent> allContents = new ArrayList<>();
        try{
            logger.info("Trying to get Contents from Database");
            allContents = contentService.getContents();
            logger.info("Data Recieved; Sending HTTP 200 response");
        }
        catch (ContentNotReturnedException e){
            e.getMessage();

        }

        allContents = contentRepository.findAll();
        return ResponseEntity.ok(allContents);

    }

    @DeleteMapping("/deleteAll")
    public void deleteContents(){
        contentRepository.deleteAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContent (@RequestBody SingleContent singleContent){
        contentRepository.save(singleContent);
        return ResponseEntity.ok("Content added!");
    }
}
