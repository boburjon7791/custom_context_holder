package com.example.custom_context_holder.sub.model.dto.response;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record ReportResponseDTO(

        ZonedDateTime createdAt,

        UUID id,

        @NotNull
        @PositiveOrZero
        BigDecimal unitPrice,

        @NotNull
        @PositiveOrZero
        BigDecimal totalSumma,

        @NotNull
        @Positive
        BigDecimal quantity,

        @NotEmpty
        String productName,

        @NotNull
        @Future
        LocalDateTime orderLastTime
){}
