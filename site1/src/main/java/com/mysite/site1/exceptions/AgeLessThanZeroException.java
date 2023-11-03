package com.mysite.site1.exceptions;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AgeLessThanZeroException extends Exception{
    public AgeLessThanZeroException(String message){
        super(message);

    }

    public AgeLessThanZeroException(Throwable cause){
        super(cause);
    }
}
