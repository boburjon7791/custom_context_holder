package com.example.custom_context_holder.sub.model.mapper;

import com.example.custom_context_holder.base.config.time_zone_context.TimeZoneContext;
import com.example.custom_context_holder.sub.model.dto.request.ReportRequestDTO;
import com.example.custom_context_holder.sub.model.dto.response.ReportResponseDTO;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.base.model.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Mapper(componentModel = "spring")
public interface ReportMapper extends BaseMapper<Report, ReportRequestDTO, ReportResponseDTO> {
    @Override
    default Report toEntity(ReportRequestDTO dto){
        return Report.builder()
                .totalSumma(dto.totalSumma())
                .orderLastTime(TimeZoneContext.convertToDefaultTimeZoneId(dto.orderLastTime()))
                .productName(dto.productName())
                .quantity(dto.quantity())
                .unitPrice(dto.unitPrice())
                .build();
    }

    @Override
    default ReportResponseDTO toDTO(Report report) {
        LocalDateTime orderLastTime = TimeZoneContext.get(report.getOrderLastTime());
        return ReportResponseDTO.builder()
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
    default void update(Report report, ReportRequestDTO dto) {
            report.setProductName(dto.productName());
            report.setQuantity(dto.quantity());
            report.setUnitPrice(dto.unitPrice());
            report.setOrderLastTime(TimeZoneContext.convertToDefaultTimeZoneId(dto.orderLastTime()));
    }
}
