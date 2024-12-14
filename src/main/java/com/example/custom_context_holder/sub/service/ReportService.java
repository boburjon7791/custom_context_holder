package com.example.custom_context_holder.sub.service;

import com.example.custom_context_holder.base.service.BaseService;
import com.example.custom_context_holder.sub.model.dto.ReportDto;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.sub.repository.ReportRepository;
import com.example.custom_context_holder.sub.model.filtering.ReportsRequestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReportService extends BaseService<Report,UUID, ReportDto, ReportsRequestFilter> {
    private final ReportRepository reportRepository;

    public void m(){
        reportRepository.findAll(PageRequest.of(0,1)).forEach(report -> {
            System.out.println("report.getId() = " + report.getId());
        });
    }

    public void m2(){
        reportRepository.findById(UUID.fromString("51e86022-8489-4402-a606-684a42f476e0"))
                .ifPresent(report -> {
                    System.out.println("report.getProductName() = " + report.getProductName());
                    report.setProductName("Testing");
                    report.setOrderLastTime(report.getOrderLastTime().plusMonths(3));
                    reportRepository.save(report);
                    Report newReport = new Report(BigDecimal.TWO, BigDecimal.valueOf(100), "sfaefaaa", BigDecimal.valueOf(200), LocalDateTime.now().plusDays(3));
                    reportRepository.save(newReport);
                });
    }
}
