package com.example.custom_context_holder.sub.model.filtering;

import com.example.custom_context_holder.base.model.filtering.BaseRequestFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestFilter extends BaseRequestFilter {
    private Boolean success;
    private BigDecimal fromPayment;
    private BigDecimal toPayment;
}
