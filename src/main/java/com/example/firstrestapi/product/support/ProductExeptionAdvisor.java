package com.example.firstrestapi.product.support;

import com.example.firstrestapi.product.support.exeption.ProductNotFoundException;
import com.example.firstrestapi.shared.api.response.ErrorMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductExeptionAdvisor {

    private static final Logger LOG = LoggerFactory.getLogger(ProductExeptionAdvisor.class);

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse productNotFound(Exception e){
        LOG.error(e.getMessage(),e);
        return new ErrorMessageResponse(e.getLocalizedMessage());
    }
}