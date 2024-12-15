package com.example.custom_context_holder.sub.controller;

import com.example.custom_context_holder.base.controller.BaseController;
import com.example.custom_context_holder.base.model.dto.ApiResponse;
import com.example.custom_context_holder.base.utils.ApiConstants;
import com.example.custom_context_holder.sub.model.dto.request.PaymentRequestDTO;
import com.example.custom_context_holder.sub.model.dto.response.PaymentResponseDTO;
import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.sub.model.filtering.PaymentRequestFilter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.BASE_PREFIX +"/payment")
public class PaymentController extends BaseController<Payment, UUID, PaymentRequestDTO, PaymentResponseDTO, PaymentRequestFilter> {

    @Operation(hidden = true)
    @Override
    public ApiResponse<PaymentResponseDTO> update(PaymentRequestDTO requestDTO, UUID uuid) {
        throw new IllegalArgumentException();
    }
}
