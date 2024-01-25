package com.mysite.site1.services.impl;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.mysite.site1.error.ContentNotReturnedException;
import com.mysite.site1.models.SingleContent;
import com.mysite.site1.repository.ContentRepository;
import com.mysite.site1.services.ContentService;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired private ContentRepository contentRepository;
    @Override
    public List<SingleContent> getContents() throws ContentNotReturnedException{
        List<SingleContent> allContents = new ArrayList<>();
        allContents = contentRepository.findAll();
        if(allContents.size() == 0){
            throw new ContentNotReturnedException(
                    "No Content Returned from Database");
            }
        return allContents;
    }

//    public String getTotalPageLength(int contentsPerPage){
//        int allContents = (int)contentRepository.count();
//        int totalPages = allContents/contentsPerPage;
//        return String.valueOf(totalPages);
//
//    }


    public Page<SingleContent> getContentsByPage(int pageNumber, int pageSize){
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return contentRepository.findAll(pageRequest);
    }
}
