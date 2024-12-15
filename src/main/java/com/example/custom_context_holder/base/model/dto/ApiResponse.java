package com.example.custom_context_holder.base.model.dto;

import lombok.Builder;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ApiResponse<T> (T data, LocalDateTime transactionTime, PaginationResponse pagination, String message, String code){

    public static <T> ApiResponse<T> ok(){
        return ApiResponse.<T>builder()
                .code(ResponseCodes.OK)
                .transactionTime(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> ok(T data){
        return ApiResponse.<T>builder()
                .data(data)
                .code(ResponseCodes.OK)
                .transactionTime(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<List<T>> ok(Page<T> paginationData){
        return ApiResponse.<List<T>>builder()
                .data(paginationData.getContent())
                .pagination(PaginationResponse.of(paginationData))
                .code(ResponseCodes.OK)
                .transactionTime(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> error(String message, String code){
        return ApiResponse.<T>builder()
                .message(message)
                .code(code)
                .transactionTime(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> error(String code){
        return ApiResponse.<T>builder()
                .code(code)
                .transactionTime(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> error(T data, String code){
        return ApiResponse.<T>builder()
                .data(data)
                .code(code)
                .transactionTime(LocalDateTime.now())
                .build();
    }
}
