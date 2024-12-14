package com.example.custom_context_holder.sub.model.filtering;

import com.example.custom_context_holder.base.model.filtering.BaseRequestFilter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ReportsRequestFilter extends BaseRequestFilter {
        BigDecimal fromUnitPrice;
        BigDecimal toUnitPrice;
        BigDecimal fromQuantity;
        BigDecimal toQuantity;
}
