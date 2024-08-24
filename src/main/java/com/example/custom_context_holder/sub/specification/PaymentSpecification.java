package com.example.custom_context_holder.sub.specification;

import com.example.custom_context_holder.base.specification.SpecificationUtils;
import com.example.custom_context_holder.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.sub.specification.request_params.PaymentRequestModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class PaymentSpecification implements SpecificationUtils<Payment, PaymentRequestModel> {
    @Override
    public Specification<Payment> specification(PaymentRequestModel request) {
        Specification<Payment> emptySpecification=Specification.where(null);

        if (request.getFromDate()!=null) {
            emptySpecification=emptySpecification.and(fromCreatedAt(TimeZoneContext.convertToDefaultTimeZoneId(request.getFromDate())));
        }

        if (request.getToDate()!=null){
            emptySpecification=emptySpecification.and(toCreatedAt(TimeZoneContext.convertToDefaultTimeZoneId(request.getToDate())));
        }

        if (request.getSuccess()!=null){
            emptySpecification=emptySpecification.and(success(request.getSuccess()));
        }

        if (request.getSearch()!=null && !request.getSearch().isBlank()){
            emptySpecification=emptySpecification.and(containsCashierName(request.getSearch()));
        }

        if (request.getFromPayment()!=null) {
            emptySpecification=emptySpecification.and(fromPayment(request.getFromPayment()));
        }

        if (request.getToPayment()!=null) {
            emptySpecification=emptySpecification.and(toPayment(request.getToPayment()));
        }

        return emptySpecification;
    }

    public static Specification<Payment> fromCreatedAt(LocalDateTime fromCreatedAt){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Payment._createdAt), fromCreatedAt);
    }

    public static Specification<Payment> toCreatedAt(LocalDateTime toCreatedAt){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Payment._createdAt), toCreatedAt);
    }

    public static Specification<Payment> success(Boolean success){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Payment._success), success);
    }

    public static Specification<Payment> containsCashierName(String cashierName){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(Payment._cashierName)), SpecificationUtils.likeExpression(cashierName));
    }

    public static Specification<Payment> fromPayment(BigDecimal fromPayment){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Payment._payment), fromPayment);
    }

    public static Specification<Payment> toPayment(BigDecimal toPayment){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Payment._payment), toPayment);
    }
}
