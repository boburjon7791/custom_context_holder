package com.example.custom_context_holder.sub.model.mapper;

import com.example.custom_context_holder.base.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.sub.model.dto.ReportDto;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.base.model.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Mapper(componentModel = "spring")
public interface ReportMapper extends BaseMapper<Report, ReportDto> {
    @Override
    default Report toEntity(ReportDto dto){
        return Report.builder()
                .totalSumma(dto.totalSumma())
                .orderLastTime(TimeZoneContext.convertToDefaultTimeZoneId(dto.orderLastTime()))
                .productName(dto.productName())
                .quantity(dto.quantity())
                .unitPrice(dto.unitPrice())
                .build();
    }

    @Override
    default ReportDto toDto(Report report) {
        LocalDateTime orderLastTime = TimeZoneContext.get(report.getOrderLastTime());
        return ReportDto.builder()
                .id(report.getId())
                .createdAt(TimeZoneContext.getZoneId(report.getCreatedAt()))
                .quantity(report.getQuantity())
                .unitPrice(report.getUnitPrice())
                .totalSumma(report.getTotalSumma())
                .orderLastTime(orderLastTime)
                .productName(report.getProductName())
                .build();
    }

    @Override
    default Report update(Report report, ReportDto dto) {
            report.setProductName(dto.productName());
            report.setQuantity(dto.quantity());
            report.setUnitPrice(dto.unitPrice());
            report.setOrderLastTime(TimeZoneContext.convertToDefaultTimeZoneId(dto.orderLastTime()));
            return report;
    }
}
