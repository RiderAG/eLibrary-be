package com.rider.elibrary.user.controller;

import com.rider.elibrary.user.error.exception.UserApiException;
import com.rider.elibrary.user.error.response.ApiErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserApiException.class)
    public ResponseEntity<ApiErrorResponse> handleUserApiException(UserApiException ex) {
        return ResponseEntity.status(ex.getErrorModel().getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiErrorResponse(ex.getErrorModel().getCode(), ex.getMessage()));
    }

}
