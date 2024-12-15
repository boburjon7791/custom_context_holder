package com.example.custom_context_holder.base.specification;

import com.example.custom_context_holder.base.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.base.model.entity.BaseEntity;
import com.example.custom_context_holder.base.model.filtering.BaseRequestFilter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public interface BaseSpecification<ENTITY, REQUEST> {
    String toDateFunction="trunc";
    Specification<ENTITY> specification(REQUEST request);

    default Specification<ENTITY> fromCreatedAt(LocalDate fromCreatedDate){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.function(toDateFunction,LocalDate.class,root.get(BaseEntity._createdAt)), TimeZoneContext.get(fromCreatedDate));
    }

    default Specification<ENTITY> toCreatedAt(LocalDate toCreatedDate){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.function(toDateFunction,LocalDate.class,root.get(BaseEntity._createdAt)), TimeZoneContext.get(toCreatedDate));
    }

    default String likeExpression(String text){
        return "%"+text.toLowerCase()+"%";
    }
}
