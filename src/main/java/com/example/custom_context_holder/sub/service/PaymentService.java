package com.example.custom_context_holder.sub.service;

import com.example.custom_context_holder.base.service.BaseService;
import com.example.custom_context_holder.sub.model.dto.request.PaymentRequestDTO;
import com.example.custom_context_holder.sub.model.dto.response.PaymentResponseDTO;
import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.sub.model.filtering.PaymentRequestFilter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService extends BaseService<Payment, UUID, PaymentRequestDTO, PaymentResponseDTO, PaymentRequestFilter> {
    @Override
    public String getEntityName() {
        return Payment._payment;
    }

    @Override
    public void checkCreating(PaymentRequestDTO requestDTO) {

    }

    @Override
    public void checkUpdating(PaymentRequestDTO requestDTO, UUID uuid) {

    }
}
