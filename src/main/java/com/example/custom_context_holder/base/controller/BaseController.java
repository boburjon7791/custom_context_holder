package com.example.custom_context_holder.base.controller;

import com.example.custom_context_holder.base.model.dto.ApiResponse;
import com.example.custom_context_holder.base.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<ENTITY, ID, REQUEST_DTO, RESPONSE_DTO, FILTERING> {
    private BaseService<ENTITY,ID, REQUEST_DTO, RESPONSE_DTO, FILTERING> baseService;

    @Autowired
    public void setBaseService(@Lazy BaseService<ENTITY, ID, REQUEST_DTO, RESPONSE_DTO, FILTERING> baseService) {
        this.baseService = baseService;
    }

    @PostMapping
    public ApiResponse<RESPONSE_DTO> create(@RequestBody @Valid REQUEST_DTO dto){
        return ApiResponse.ok(baseService.create(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<RESPONSE_DTO> update(@RequestBody @Valid REQUEST_DTO dto, @PathVariable ID id){
        return ApiResponse.ok(baseService.update(dto, id));
    }

    @GetMapping("/{id}")
    public ApiResponse<RESPONSE_DTO> findById(@PathVariable ID id){
        return ApiResponse.ok(baseService.findById(id));
    }

    @GetMapping
    public ApiResponse<List<RESPONSE_DTO>> findAll(@ModelAttribute FILTERING request){
        return baseService.findAll(request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteById(@PathVariable ID id){
        baseService.deleteById(id);
        return ApiResponse.ok();
    }
}
