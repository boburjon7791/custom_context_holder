package com.example.custom_context_holder.sub.service;

import com.example.custom_context_holder.base.service.BaseService;
import com.example.custom_context_holder.sub.model.dto.PaymentDto;
import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.sub.specification.request_params.PaymentRequestModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService extends BaseService<Payment, UUID, PaymentDto, PaymentRequestModel> {
    @Override
    public PaymentDto update(PaymentDto paymentDto, UUID uuid) {
        throw new IllegalArgumentException();
    }
}
