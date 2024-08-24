package com.example.custom_context_holder.sub.specification.request_params;

import com.example.custom_context_holder.base.specification.request_model.BaseRequestModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ReportsRequestModel extends BaseRequestModel {
        BigDecimal fromUnitPrice;
        BigDecimal toUnitPrice;
        BigDecimal fromQuantity;
        BigDecimal toQuantity;
}
