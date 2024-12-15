package com.example.custom_context_holder.sub.specification;

import com.example.custom_context_holder.base.specification.BaseSpecification;
import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.sub.model.filtering.PaymentRequestFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentSpecification implements BaseSpecification<Payment, PaymentRequestFilter> {
    @Override
    public Specification<Payment> specification(PaymentRequestFilter request) {
        Specification<Payment> emptySpecification=Specification.where(null);

        if (request.getFromDate()!=null) {
            emptySpecification=emptySpecification.and(fromCreatedAt(request.getFromDate()));
        }

        if (request.getToDate()!=null){
            emptySpecification=emptySpecification.and(toCreatedAt(request.getToDate()));
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

    public Specification<Payment> success(Boolean success){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Payment._success), success);
    }

    public Specification<Payment> containsCashierName(String cashierName){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(Payment._cashierName)), likeExpression(cashierName));
    }

    public Specification<Payment> fromPayment(BigDecimal fromPayment){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Payment._payment), fromPayment);
    }

    public Specification<Payment> toPayment(BigDecimal toPayment){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Payment._payment), toPayment);
    }
}
