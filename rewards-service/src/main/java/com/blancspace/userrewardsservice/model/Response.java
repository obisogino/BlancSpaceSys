package com.blancspace.userrewardsservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response<T> {


    private Integer status;

    private String code;

    private String description;

//    private List<ErrorDetail> errorDetails = new ArrayList<>();

    private T body;

//    public Response<T> add(String code, String message) {
//        return add(new ErrorDetail(code, message));
//    }

//    public Response<T> add(String code, String message, String details) {
//        return add(new ErrorDetail(code, message, details));
//    }

//    public Response<T> add(ErrorDetail detail) {
//        this.getErrorDetails().add(detail);
//        return this;
//    }

}