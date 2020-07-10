package com.rider.elibrary.catalog.controller;

import com.rider.elibrary.catalog.error.exception.CatalogApiException;
import com.rider.elibrary.catalog.error.response.ApiExceptionResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CatalogApiException.class)
    public ResponseEntity handleCatalogApiException(CatalogApiException ex) {
        return ResponseEntity.status(ex.getErrorModel().getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiExceptionResponse(ex.getErrorModel().getCode(), ex.getMessage()));
    }

}
