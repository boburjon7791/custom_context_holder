package com.example.custom_context_holder.base.specification;

import com.example.custom_context_holder.base.model.entity.BaseEntity;
import com.example.custom_context_holder.base.specification.request_model.BaseRequestModel;
import com.example.custom_context_holder.config.time_zone_context.TimeZoneContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface SpecificationUtils<ENTITY, REQUEST> {
    Specification<ENTITY> specification(REQUEST request);

    static <ENTITY> Specification<ENTITY> fromCreatedAt(LocalDate fromCreatedDate){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(BaseEntity._createdAt), TimeZoneContext.get(LocalDateTime.of(fromCreatedDate, LocalTime.MIN)));
    }

    static <ENTITY> Specification<ENTITY> toCreatedAt(LocalDate toCreatedDate){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(BaseEntity._createdAt), TimeZoneContext.get(LocalDateTime.of(toCreatedDate, LocalTime.MAX)));
    }

    default Pageable pageable(REQUEST request) {
        BaseRequestModel requestModel = (BaseRequestModel)request;
        return PageRequest.of(requestModel.getPage(), requestModel.getSize(), Sort.by(Sort.Direction.DESC, BaseEntity._createdAt));
    }

    static String likeExpression(String text){
        return "%"+text.toLowerCase()+"%";
    }
}
