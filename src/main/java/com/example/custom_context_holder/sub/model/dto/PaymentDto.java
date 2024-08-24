package com.example.custom_context_holder.sub.model.dto;

import com.example.custom_context_holder.base.model.dto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class PaymentDto extends BaseDto {
    private UUID id;

    private ZonedDateTime createdAt;

    @NotNull
    @Positive
    private BigDecimal payment;

    private Boolean success;

    @NotBlank
    private String cashierName;
}
