package com.mysite.site1.services;

import com.mysite.site1.error.ContentNotReturnedException;
import com.mysite.site1.models.SingleContent;

import java.util.List;

public interface ContentService {

    List<SingleContent> getContents() throws ContentNotReturnedException;
}
