package com.example.custom_context_holder.base.model.filtering;

import com.example.custom_context_holder.base.model.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class BaseRequestFilter {
    private int page;
    private int size=10;
    private String search;
    private LocalDate fromDate;
    private LocalDate toDate;
    private boolean all;
    public Pageable pageable() {
        return PageRequest.of(page, size, sort());
    }
    public Sort sort(){
        return Sort.by(Sort.Direction.DESC, BaseEntity._createdAt);
    }
}
