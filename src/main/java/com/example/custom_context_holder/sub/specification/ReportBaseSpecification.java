package com.example.custom_context_holder.sub.specification;

import com.example.custom_context_holder.base.specification.BaseSpecification;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.sub.model.filtering.ReportsRequestFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ReportBaseSpecification implements BaseSpecification<Report, ReportsRequestFilter> {

    public static Specification<Report> fromUnitPrice(BigDecimal unitPrice){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Report._unitPrice), unitPrice);
    }

    public static Specification<Report> toUnitPrice(BigDecimal unitPrice){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Report._unitPrice), unitPrice);
    }

    public static Specification<Report> containsProductName(String productName){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(Report._productName)), BaseSpecification.likeExpression(productName));
    }

    public static Specification<Report> fromQuantity(BigDecimal quantity){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Report._quantity), quantity);
    }

    public static Specification<Report> toQuantity(BigDecimal quantity){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Report._quantity), quantity);
    }

    @Override
    public Specification<Report> specification(ReportsRequestFilter request){
        Specification<Report> emptySpecification = Specification.where(null);

        if (request.getFromDate()!=null) {
            emptySpecification=emptySpecification.and(BaseSpecification.fromCreatedAt(request.getFromDate()));
        }

        if (request.getToDate()!=null) {
            emptySpecification=emptySpecification.and(BaseSpecification.toCreatedAt(request.getToDate()));
        }

        if (request.getFromUnitPrice()!=null) {
            emptySpecification=emptySpecification.and(ReportBaseSpecification.fromUnitPrice(request.getFromUnitPrice()));
        }

        if (request.getToUnitPrice()!=null) {
            emptySpecification=emptySpecification.and(ReportBaseSpecification.toUnitPrice(request.getToUnitPrice()));
        }

        if (request.getSearch()!=null && !request.getSearch().isBlank()) {
            emptySpecification=emptySpecification.and(ReportBaseSpecification.containsProductName(request.getSearch()));
        }

        if (request.getFromQuantity()!=null) {
            emptySpecification=emptySpecification.and(ReportBaseSpecification.fromQuantity(request.getFromQuantity()));
        }

        if (request.getToQuantity()!=null) {
            emptySpecification=emptySpecification.and(ReportBaseSpecification.toQuantity(request.getToQuantity()));
        }

        return emptySpecification;
    }
}
