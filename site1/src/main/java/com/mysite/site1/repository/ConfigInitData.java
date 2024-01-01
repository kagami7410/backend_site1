package com.mysite.site1.repository;

import com.mysite.site1.models.SingleContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigInitData {

    @Autowired
    ContentRepository contentRepository;

    List<SingleContent> contents = new ArrayList<>();

    @Bean
    void addContentsToDataBase(){
        for(int i = 0; i < 120; i++){
            SingleContent singleContent = new SingleContent();
            singleContent.setTitle("someTitle " + i);
            singleContent.setDescription("someDescription " + i);
            singleContent.setUrl("someUrl " + i);

            contentRepository.save(singleContent);
        }
    }
}
