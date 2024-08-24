package com.example.custom_context_holder.base.model.mapper;

public interface BaseMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
    ENTITY update(ENTITY entity, DTO dto);
}
