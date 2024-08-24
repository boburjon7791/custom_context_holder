package com.example.custom_context_holder.sub.model.mapper;

import com.example.custom_context_holder.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.sub.model.dto.PaymentDto;
import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.base.model.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PaymentMapper extends BaseMapper<Payment, PaymentDto> {
    @Override
    default Payment toEntity(PaymentDto paymentDto) {
        return Payment.builder()
                .payment(paymentDto.getPayment())
                .cashierName(paymentDto.getCashierName())
                .success(true)
                .build();
    }

    @Override
    default PaymentDto toDto(Payment payment) {
        return PaymentDto.builder()
                .id(payment.getId())
                .createdAt(TimeZoneContext.getZoneId(payment.getCreatedAt()))
                .payment(payment.getPayment())
                .deleted(payment.isDeleted())
                .success(payment.getSuccess())
                .cashierName(payment.getCashierName())
                .build();
    }

    @Override
    default Payment update(Payment payment, PaymentDto paymentDto) {
        throw new RuntimeException("payment can not update");
    }
}
