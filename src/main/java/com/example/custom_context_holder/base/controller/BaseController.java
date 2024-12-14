package com.example.custom_context_holder.base.controller;

import com.example.custom_context_holder.base.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

public class BaseController<ENTITY, ID, DTO, FILTERING> {
    private BaseService<ENTITY,ID, DTO, FILTERING> baseService;

    @Autowired
    public void setBaseService(@Lazy BaseService<ENTITY, ID, DTO, FILTERING> baseService) {
        this.baseService = baseService;
    }

    @PostMapping
    public DTO create(@RequestBody @Valid DTO dto){
        return baseService.create(dto);
    }

    @PutMapping("/{id}")
    public DTO update(@RequestBody @Valid DTO dto, @PathVariable ID id){
        return baseService.update(dto, id);
    }

    @GetMapping("/{id}")
    public DTO findById(@PathVariable ID id){
        return baseService.findById(id);
    }

    @GetMapping
    public Page<DTO> findAll(@ModelAttribute FILTERING request){
        return baseService.findAll(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id){
        baseService.deleteById(id);
    }
}
