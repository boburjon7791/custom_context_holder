package com.example.custom_context_holder.base.specification;

import com.example.custom_context_holder.base.model.entity.BaseEntity;
import com.example.custom_context_holder.base.specification.request_model.BaseRequestModel;
import com.example.custom_context_holder.sub.specification.request_params.ReportsRequestModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationUtils<ENTITY, REQUEST> {
    Specification<ENTITY> specification(REQUEST request);
    default Pageable pageable(REQUEST request) {
        BaseRequestModel requestModel = (BaseRequestModel)request;
        return PageRequest.of(requestModel.getPage(), requestModel.getSize(), Sort.by(Sort.Direction.DESC, BaseEntity._createdAt));
    }
    static String likeExpression(String text){
        return "%"+text.toLowerCase()+"%";
    }
}
