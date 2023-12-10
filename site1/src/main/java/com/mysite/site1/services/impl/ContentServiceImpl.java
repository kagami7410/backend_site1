package com.mysite.site1.services.impl;

import com.mysite.site1.models.SingleContent;
import com.mysite.site1.repository.ContentRepository;
import com.mysite.site1.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired private ContentRepository contentRepository;
    @Override
    public List<SingleContent> getContents() {
        List<SingleContent> allContents = new ArrayList<>();
        try{
            allContents = contentRepository.findAll();

        }
        catch (Exception e){
            e.getMessage();
        }
        return allContents;
    }
}
