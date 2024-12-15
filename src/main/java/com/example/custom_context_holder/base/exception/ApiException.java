package com.example.custom_context_holder.base.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private final Object object;
    private final String code;
    public ApiException(String code){
        object=null;
        this.code=code;
    }
    public ApiException(String message, String code){
        super(message);
        object=null;
        this.code=code;
    }

    public ApiException(Object object, String code){
        this.object=object;
        this.code=code;
    }
}
