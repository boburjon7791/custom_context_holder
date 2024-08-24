package com.example.custom_context_holder.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<BaseEntity, ID> extends JpaRepository<BaseEntity, ID>, JpaSpecificationExecutor<BaseEntity> {
}
