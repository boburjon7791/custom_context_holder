package com.example.custom_context_holder.sub.specification.request_params;

import com.example.custom_context_holder.base.specification.request_model.BaseRequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestModel extends BaseRequestModel {
    private Boolean success;
    private BigDecimal fromPayment;
    private BigDecimal toPayment;
}
