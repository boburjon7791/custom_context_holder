package com.example.custom_context_holder.base.model.mapper;

public interface BaseMapper<ENTITY, REQUEST_DTO, RESPONSE_DTO> {
    ENTITY toEntity(REQUEST_DTO dto);
    RESPONSE_DTO toDTO(ENTITY entity);
    void update(ENTITY entity, REQUEST_DTO dto);
}
