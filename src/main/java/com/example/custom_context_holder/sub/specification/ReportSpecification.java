package com.example.custom_context_holder.sub.specification;

import com.example.custom_context_holder.base.specification.SpecificationUtils;
import com.example.custom_context_holder.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.sub.specification.request_params.ReportsRequestModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ReportSpecification implements SpecificationUtils<Report, ReportsRequestModel> {

    public static Specification<Report> fromUnitPrice(BigDecimal unitPrice){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Report._unitPrice), unitPrice);
    }

    public static Specification<Report> toUnitPrice(BigDecimal unitPrice){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Report._unitPrice), unitPrice);
    }

    public static Specification<Report> containsProductName(String productName){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(Report._productName)), SpecificationUtils.likeExpression(productName));
    }

    public static Specification<Report> fromQuantity(BigDecimal quantity){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Report._quantity), quantity);
    }

    public static Specification<Report> toQuantity(BigDecimal quantity){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Report._quantity), quantity);
    }

    @Override
    public Specification<Report> specification(ReportsRequestModel request){
        Specification<Report> emptySpecification = Specification.where(null);

        if (request.getFromDate()!=null) {
            emptySpecification=emptySpecification.and(SpecificationUtils.fromCreatedAt(request.getFromDate()));
        }

        if (request.getToDate()!=null) {
            emptySpecification=emptySpecification.and(SpecificationUtils.toCreatedAt(request.getToDate()));
        }

        if (request.getFromUnitPrice()!=null) {
            emptySpecification=emptySpecification.and(ReportSpecification.fromUnitPrice(request.getFromUnitPrice()));
        }

        if (request.getToUnitPrice()!=null) {
            emptySpecification=emptySpecification.and(ReportSpecification.toUnitPrice(request.getToUnitPrice()));
        }

        if (request.getSearch()!=null && !request.getSearch().isBlank()) {
            emptySpecification=emptySpecification.and(ReportSpecification.containsProductName(request.getSearch()));
        }

        if (request.getFromQuantity()!=null) {
            emptySpecification=emptySpecification.and(ReportSpecification.fromQuantity(request.getFromQuantity()));
        }

        if (request.getToQuantity()!=null) {
            emptySpecification=emptySpecification.and(ReportSpecification.toQuantity(request.getToQuantity()));
        }

        return emptySpecification;
    }
}
