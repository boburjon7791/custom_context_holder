package com.example.custom_context_holder.base.service;

import com.example.custom_context_holder.base.model.entity.BaseEntity;
import com.example.custom_context_holder.base.model.mapper.BaseMapper;
import com.example.custom_context_holder.base.repository.BaseRepository;
import com.example.custom_context_holder.base.specification.BaseSpecification;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

@Getter
public class BaseService<ENTITY,ID, DTO, FILTERING> {
    private BaseRepository<ENTITY, ID> baseRepository;
    private BaseMapper<ENTITY, DTO> baseMapper;
    private BaseSpecification<ENTITY, FILTERING> baseSpecification;

    @Autowired
    public void setBaseRepository(@Lazy BaseRepository<ENTITY, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Autowired
    public void setBaseMapper(@Lazy BaseMapper<ENTITY, DTO> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Autowired
    public void setBaseSpecification(@Lazy BaseSpecification<ENTITY, FILTERING> baseSpecification) {
        this.baseSpecification = baseSpecification;
    }

    public DTO create(DTO dto){
        return baseMapper.toDto(baseRepository.save(baseMapper.toEntity(dto)));
    }

    public DTO findById(ID id){
        return baseMapper.toDto(entity(id));
    }

    public DTO update(DTO dto, ID id){
        return baseMapper.toDto(baseRepository.save(baseMapper.update(entity(id), dto)));
    }

    public Page<DTO> findAll(FILTERING request){
        Specification<ENTITY> specification = baseSpecification.specification(request);
        Pageable pageable = baseSpecification.pageable(request);
        return baseRepository.findAll(specification, pageable)
                .map(baseMapper::toDto);
    }

    public void deleteById(ID id){
        baseRepository.deleteById(id);
    }

    public ENTITY entity(ID id){
        return baseRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException(BaseEntity.class.getName()+" not found"));
    }
}
