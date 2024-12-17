package com.example.custom_context_holder.base.service;

import com.example.custom_context_holder.base.config.internationalization.Localization;
import com.example.custom_context_holder.base.exception.ApiException;
import com.example.custom_context_holder.base.model.dto.ApiResponse;
import com.example.custom_context_holder.base.model.dto.ResponseCodes;
import com.example.custom_context_holder.base.model.entity.BaseEntity;
import com.example.custom_context_holder.base.model.filtering.BaseRequestFilter;
import com.example.custom_context_holder.base.model.mapper.BaseMapper;
import com.example.custom_context_holder.base.repository.BaseRepository;
import com.example.custom_context_holder.base.specification.BaseSpecification;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Getter
public abstract class BaseService<ENTITY,ID, REQUEST_DTO, RESPONSE_DTO, FILTERING> {
    private BaseRepository<ENTITY, ID> baseRepository;
    private BaseMapper<ENTITY, REQUEST_DTO, RESPONSE_DTO> baseMapper;
    private BaseSpecification<ENTITY, FILTERING> baseSpecification;
    private Localization localization;

    @Autowired
    public void setLocalization(@Lazy Localization localization) {
        this.localization = localization;
    }

    @Autowired
    public void setBaseRepository(@Lazy BaseRepository<ENTITY, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Autowired
    public void setBaseMapper(@Lazy BaseMapper<ENTITY, REQUEST_DTO, RESPONSE_DTO> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Autowired
    public void setBaseSpecification(@Lazy BaseSpecification<ENTITY, FILTERING> baseSpecification) {
        this.baseSpecification = baseSpecification;
    }

    public abstract String getEntityName();
    public abstract void checkCreating(REQUEST_DTO dto);
    public abstract void checkUpdating(REQUEST_DTO dto, ID id);

    public RESPONSE_DTO create(REQUEST_DTO dto){
        checkCreating(dto);
        return baseMapper.toDTO(baseRepository.save(baseMapper.toEntity(dto)));
    }

    public RESPONSE_DTO findById(ID id){
        return baseMapper.toDTO(entity(id));
    }

    public RESPONSE_DTO update(REQUEST_DTO dto, ID id){
        checkUpdating(dto, id);
        ENTITY entity = entity(id);
        baseMapper.update(entity, dto);
        ENTITY saved = baseRepository.save(entity);
        return baseMapper.toDTO(saved);
    }

    public ApiResponse<List<RESPONSE_DTO>> findAll(FILTERING request){
        if(request instanceof BaseRequestFilter requestFilter){
            if (requestFilter.isAll()) {
                List<RESPONSE_DTO> responseDTOList = baseRepository.findAll(requestFilter.sort()).stream().map(baseMapper::toDTO).toList();
                return ApiResponse.ok(responseDTOList);
            }
            Pageable pageable = requestFilter.pageable();
            Specification<ENTITY> specification = baseSpecification.specification(request);
            Page<RESPONSE_DTO> page = baseRepository.findAll(specification, pageable)
                    .map(baseMapper::toDTO);
            return ApiResponse.ok(page);
        }
        throw new ApiException(ResponseCodes.SERVER_ERROR);
    }

    public void deleteById(ID id){
        ENTITY entity = entity(id);
        if (entity instanceof BaseEntity baseEntity) {
            baseEntity.setDeleted(true);
            baseRepository.save(entity);
            return;
        }
        throw new ApiException(ResponseCodes.SERVER_ERROR);
    }

    public ENTITY entity(ID id){
        return baseRepository.findById(id)
                        .orElseThrow(() -> new ApiException(getEntityName()+" not found", ResponseCodes.NOT_FOUND));
    }
}
