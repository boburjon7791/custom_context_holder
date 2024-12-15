package com.example.custom_context_holder.sub.model.mapper;

import com.example.custom_context_holder.base.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.sub.model.dto.request.PaymentRequestDTO;
import com.example.custom_context_holder.sub.model.dto.response.PaymentResponseDTO;
import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.base.model.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PaymentMapper extends BaseMapper<Payment, PaymentRequestDTO, PaymentResponseDTO> {
    @Override
    default Payment toEntity(PaymentRequestDTO paymentDto) {
        return Payment.builder()
                .payment(paymentDto.payment())
                .cashierName(paymentDto.cashierName())
                .success(true)
                .build();
    }

    @Override
    default PaymentResponseDTO toDTO(Payment payment) {
        return PaymentResponseDTO.builder()
                .id(payment.getId())
                .createdAt(TimeZoneContext.getZoneId(payment.getCreatedAt()))
                .payment(payment.getPayment())
                .success(payment.getSuccess())
                .cashierName(payment.getCashierName())
                .build();
    }

    @Override
    default void update(Payment payment, PaymentRequestDTO requestDTO) {
        throw new RuntimeException("payment can not update");
    }
}
