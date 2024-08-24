package com.example.custom_context_holder.base.specification.request_model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;


@Getter
@Setter
@NoArgsConstructor
public class BaseRequestModel {
    private Integer page=0;
    private Integer size=10;
    private String search;
    private ZonedDateTime fromDate;
    private ZonedDateTime toDate;
}
