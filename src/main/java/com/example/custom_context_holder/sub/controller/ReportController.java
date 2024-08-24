package com.example.custom_context_holder.sub.controller;

import com.example.custom_context_holder.base.controller.BaseController;
import com.example.custom_context_holder.sub.model.dto.ReportDto;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.sub.specification.request_params.ReportsRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/reports")
public class ReportController extends BaseController<Report, UUID, ReportDto, ReportsRequestModel> {
    @Override
    public void deleteById(UUID uuid) {
        throw new IllegalArgumentException();
    }
}
