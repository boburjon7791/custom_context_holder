package com.example.custom_context_holder.sub.controller;

import com.example.custom_context_holder.base.controller.BaseController;
import com.example.custom_context_holder.base.model.dto.ApiResponse;
import com.example.custom_context_holder.base.utils.ApiConstants;
import com.example.custom_context_holder.sub.model.dto.request.ReportRequestDTO;
import com.example.custom_context_holder.sub.model.dto.response.ReportResponseDTO;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.sub.model.filtering.ReportsRequestFilter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.BASE_PREFIX+"/reports")
public class ReportController extends BaseController<Report, UUID, ReportRequestDTO, ReportResponseDTO, ReportsRequestFilter> {
    @Operation(hidden = true)
    @Override
    public ApiResponse<Void> deleteById(UUID id) {
        throw new IllegalArgumentException();
    }
}
