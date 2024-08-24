package com.example.custom_context_holder.sub.repository;

import com.example.custom_context_holder.sub.model.entity.Payment;
import com.example.custom_context_holder.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends BaseRepository<Payment, UUID> {
}
