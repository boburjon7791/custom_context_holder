package com.example.custom_context_holder.base.model.dto;

import org.springframework.data.domain.Page;

public record PaginationResponse(int totalPages, int pageSize, long totalElements, int currentPage) {
    public static PaginationResponse of(Page<?> page){
        return new PaginationResponse(page.getTotalPages(), page.getSize(), page.getTotalElements(), page.getNumber());
    }
}
