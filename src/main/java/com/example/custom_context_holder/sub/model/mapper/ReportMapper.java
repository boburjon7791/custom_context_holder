package com.example.custom_context_holder.sub.model.mapper;

import com.example.custom_context_holder.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.sub.model.dto.ReportDto;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.base.model.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ReportMapper extends BaseMapper<Report, ReportDto> {
    @Override
    default ReportDto toDto(Report report) {
        return ReportDto.builder()
                .id(report.getId())
                .createdAt(TimeZoneContext.getZoneId(report.getCreatedAt()))
                .quantity(report.getQuantity())
                .unitPrice(report.getUnitPrice())
                .deleted(report.isDeleted())
                .totalSumma(report.getTotalSumma())
                .orderLastTime(TimeZoneContext.getZoneId(report.getOrderLastTime()))
                .productName(report.getProductName())
                .build();
    }

    @Override
    default Report update(Report report, ReportDto dto) {
            report.setProductName(dto.getProductName());
            report.setQuantity(dto.getQuantity());
            report.setUnitPrice(dto.getUnitPrice());
            report.setOrderLastTime(TimeZoneContext.convertToDefaultTimeZoneId(dto.getOrderLastTime()));
            return report;
    }
}
