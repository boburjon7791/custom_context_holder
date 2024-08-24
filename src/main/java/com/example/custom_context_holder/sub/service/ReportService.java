package com.example.custom_context_holder.sub.service;

import com.example.custom_context_holder.base.service.BaseService;
import com.example.custom_context_holder.sub.model.dto.ReportDto;
import com.example.custom_context_holder.sub.model.entity.Report;
import com.example.custom_context_holder.sub.specification.request_params.ReportsRequestModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReportService extends BaseService<Report,UUID, ReportDto, ReportsRequestModel> {}
