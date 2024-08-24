package com.example.custom_context_holder.sub.controller;

import com.example.custom_context_holder.base.controller.BaseController;
import com.example.custom_context_holder.sub.model.dto.PaymentDto;
import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.sub.specification.request_params.PaymentRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/payment")
public class PaymentController extends BaseController<Payment, UUID, PaymentDto, PaymentRequestModel> {
}
