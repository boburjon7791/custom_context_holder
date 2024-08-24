package com.example.custom_context_holder.base.specification.request_model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


@Getter
@Setter
@NoArgsConstructor
public class BaseRequestModel {
    private Integer page=0;
    private Integer size=10;
    private String search;
    private LocalDate fromDate;
    private LocalDate toDate;
}
