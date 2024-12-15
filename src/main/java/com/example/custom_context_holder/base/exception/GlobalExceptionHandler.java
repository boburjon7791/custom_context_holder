package com.example.custom_context_holder.base.exception;

import com.example.custom_context_holder.base.model.dto.ApiResponse;
import com.example.custom_context_holder.base.model.dto.ResponseCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<?> handle(Exception e){
        log.error("Handle exception : {0}",e);
        return ApiResponse.error(e.toString(), ResponseCodes.SERVER_ERROR);
    }

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse<Object> handle(ApiException e){
        log.warn("Handle exception : {0}",e);
        return e.getObject()!=null ? ApiResponse.error(e.getObject(), e.getCode()) : ApiResponse.error(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handle(MethodArgumentNotValidException e){
        log.warn("Handle exception : {0}",e);
        return ApiResponse.error(e.toString(), ResponseCodes.VALIDATION_ERROR);
    }
}
