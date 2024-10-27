package com.blancspace.userrewardsservice.util;

import com.blancspace.userrewardsservice.model.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseConverter {

//    public static <S extends HttpHeaders, T> ResponseEntity<Response<T>> convert(RestResponseContentWrapper<S, T> wrapper) {
//        Response<T> response = new Response<>();
//        response.setBody(wrapper.getBody());
//        response.setStatus(ResponseStatus.SUCCESS);
//        response.setCode("0");
//        response.setDescription("Success");
//
//        if (!wrapper.getWarnings().isEmpty()) {
//            response.setStatus(ResponseStatus.WARNING);
//            response.setCode(wrapper.getWarningCode());
//            response.setDescription(wrapper.getWarningMessage());
//            response.getErrorDetails().addAll(wrapper.getWarnings());
//        }
//
//        return new ResponseEntity<>(response, wrapper.getHeader(), HttpStatus.OK);
//    }

    public static  <S extends HttpHeaders, T> ResponseEntity<Response<T>> convert(T body){
        Response<T> response = new Response<>();
        response.setBody(body);

        response.setCode("0");
        response.setDescription("Success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}