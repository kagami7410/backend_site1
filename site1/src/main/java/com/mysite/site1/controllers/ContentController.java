package com.mysite.site1.controllers;

import com.mysite.site1.error.ContentNotReturnedException;
import com.mysite.site1.models.SingleContent;
import com.mysite.site1.repository.ContentRepository;
import com.mysite.site1.services.impl.ContentServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {

    Logger logger = LogManager.getLogger(ContentController.class);

    @Autowired
    ContentRepository contentRepository;

    @Autowired private ContentServiceImpl contentService;


    @GetMapping("/getAll")
    public ResponseEntity<List<SingleContent>> getAllContents(){
        List<SingleContent> allContents = new ArrayList<>();
        try{
            logger.info("Trying to get Contents from Database");
            allContents = contentService.getContents();
            logger.debug("This is a DEBUG message.");
            logger.info("Data Recieved; Sending HTTP 200 response");
            logger.debug("Data Recieved; Sending HTTP 200 response -- debug test");

        }
        catch (ContentNotReturnedException e){
            e.getMessage();

        }

        allContents = contentRepository.findAll();
        return ResponseEntity.ok(allContents);

    }



    @GetMapping("/getPage/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<SingleContent>> getAllContents(
            @PathVariable int pageNumber,
            @PathVariable int pageSize){
        return ResponseEntity.ok(contentService.getContentsByPage(pageNumber, pageSize));
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
