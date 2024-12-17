package com.example.custom_context_holder.sub.service;

import com.example.custom_context_holder.base.service.BaseService;
import com.example.custom_context_holder.sub.model.dto.request.ReportRequestDTO;
import com.example.custom_context_holder.sub.model.dto.response.ReportResponseDTO;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.sub.model.filtering.ReportsRequestFilter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReportService extends BaseService<Report,UUID, ReportRequestDTO, ReportResponseDTO, ReportsRequestFilter> {
    @Override
    public String getEntityName() {
        return Report._report;
    }

    @Override
    public void checkCreating(ReportRequestDTO reportRequestDTO) {

    }

    @Override
    public void checkUpdating(ReportRequestDTO reportRequestDTO, UUID uuid) {

    }
}
