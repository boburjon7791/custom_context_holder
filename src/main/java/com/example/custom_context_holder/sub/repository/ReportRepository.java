package com.example.custom_context_holder.sub.repository;

import com.example.custom_context_holder.base.repository.BaseRepository;
import com.example.custom_context_holder.sub.model.entity.Report;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepository extends BaseRepository<Report, UUID> {
}
