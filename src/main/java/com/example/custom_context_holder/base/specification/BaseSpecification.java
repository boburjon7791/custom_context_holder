package com.example.custom_context_holder.base.specification;

import com.example.custom_context_holder.base.model.entity.BaseEntity;
import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Date;
import java.time.LocalDate;


public interface BaseSpecification<ENTITY, REQUEST> {
    String toDateFunction="cast";
    Specification<ENTITY> specification(REQUEST request);

    default Specification<ENTITY> fromCreatedAt(LocalDate fromCreatedDate){
        return (root, query, criteriaBuilder) -> {
            Expression<Date> castedDate = criteriaBuilder.function(toDateFunction, Date.class, root.get(BaseEntity._createdAt));
            Expression<Date> createdDate = criteriaBuilder.literal(Date.valueOf(fromCreatedDate));
            return criteriaBuilder.greaterThanOrEqualTo(castedDate, createdDate);
        };
    }

    default Specification<ENTITY> toCreatedAt(LocalDate toCreatedDate){
        return (root, query, criteriaBuilder) -> {
            Expression<Date> castedDate = criteriaBuilder.function(toDateFunction, Date.class, root.get(BaseEntity._createdAt));
            Expression<Date> createdDate = criteriaBuilder.literal(Date.valueOf(toCreatedDate));
            return criteriaBuilder.lessThanOrEqualTo(castedDate, createdDate);
        };
    }

    default String likeExpression(String text){
        return "%"+text.toLowerCase()+"%";
    }
}
