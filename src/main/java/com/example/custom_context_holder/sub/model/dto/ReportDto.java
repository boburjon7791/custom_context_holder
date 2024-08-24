package com.example.custom_context_holder.sub.model.dto;

import com.example.custom_context_holder.base.model.dto.BaseDto;
import jakarta.validation.constraints.*;
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
public class ReportDto extends BaseDto {
        private UUID id;

        @NotNull
        @PositiveOrZero
        private BigDecimal unitPrice;

        @NotNull
        @PositiveOrZero
        private BigDecimal totalSumma;

        @NotNull
        @Positive
        private BigDecimal quantity;

        @NotEmpty
        private String productName;

        @NotNull
        @Future
        private ZonedDateTime orderLastTime;
}
