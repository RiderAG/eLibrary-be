package com.rider.elibrary.user.controller;

import com.rider.elibrary.user.error.exception.RegistrationException;
import com.rider.elibrary.user.error.exception.UserApiException;
import com.rider.elibrary.user.error.response.ApiErrorResponse;
import com.rider.elibrary.user.error.response.RegistrationViolationsResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<RegistrationViolationsResponse> handleRegistrationException(RegistrationException ex) {
        return ResponseEntity.status(ex.getErrorModel().getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new RegistrationViolationsResponse(ex.getErrorModel().getCode(), ex.getViolations()));
    }

    @ExceptionHandler(UserApiException.class)
    public ResponseEntity<ApiErrorResponse> handleUserApiException(UserApiException ex) {
        return ResponseEntity.status(ex.getErrorModel().getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiErrorResponse(ex.getErrorModel().getCode(), ex.getMessage()));
    }

}
