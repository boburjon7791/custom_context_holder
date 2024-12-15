package com.example.custom_context_holder.sub.model.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record PaymentResponseDTO(

    UUID id,

    ZonedDateTime createdAt,

    @NotNull
    @Positive
    BigDecimal payment,

    Boolean success,

    @NotBlank
    String cashierName
){}
