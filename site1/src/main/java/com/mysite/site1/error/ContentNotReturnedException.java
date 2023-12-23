package com.mysite.site1.error;

public class ContentNotReturnedException extends Exception {
    public ContentNotReturnedException(String message){
        super(message);
    }
    public ContentNotReturnedException(){}
}
