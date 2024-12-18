package com.example.custom_context_holder.base.specification;

import com.example.custom_context_holder.base.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.base.model.entity.BaseEntity;
import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Date;
import java.time.LocalDate;


/*
* We need to create the following function for working fromCreatedAt and toCreatedAt functions in oracle database.
* If you use postgresql database, you don't need to create any sql function.

    create or replace function timestamp_to_date(date_time timestamp)
        return date
    is
    begin
        return cast(date_time as date);
    end;

* */
public interface BaseSpecification<ENTITY, REQUEST> {
//    String toDateFunction="date"; // this is for postgresql database
    String toDateFunction="timestamp_to_date";
    Specification<ENTITY> specification(REQUEST request);

    default Specification<ENTITY> fromCreatedAt(LocalDate fromCreatedDate){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.function(toDateFunction, LocalDate.class, root.get(BaseEntity._createdAt)), fromCreatedDate);
    }

    default Specification<ENTITY> toCreatedAt(LocalDate toCreatedDate){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.function(toDateFunction, LocalDate.class, root.get(BaseEntity._createdAt)), toCreatedDate);
    }

    default String likeExpression(String text){
        return "%"+text.toLowerCase()+"%";
    }
}
