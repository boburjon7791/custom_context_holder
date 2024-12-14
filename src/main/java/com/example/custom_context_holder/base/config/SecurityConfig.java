package com.example.custom_context_holder.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class SecurityConfig {
    @Bean
    public AuditorAware<Long> auditorAware(){
        return () -> Optional.of(1L);
    }
}
