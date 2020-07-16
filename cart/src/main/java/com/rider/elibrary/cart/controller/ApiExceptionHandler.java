package com.rider.elibrary.cart.controller;

import com.rider.elibrary.cart.error.exception.CartApiException;
import com.rider.elibrary.cart.error.response.ApiErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CartApiException.class)
    public ResponseEntity<ApiErrorResponse> handleUserApiException(CartApiException ex) {
        return ResponseEntity.status(ex.getErrorModel().getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiErrorResponse(ex.getErrorModel().getCode(), ex.getMessage()));
    }

}
