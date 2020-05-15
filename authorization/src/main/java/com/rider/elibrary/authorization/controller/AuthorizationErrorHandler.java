package com.rider.elibrary.authorization.controller;

import com.rider.elibrary.authorization.error.exception.IncomingApiException;
import com.rider.elibrary.authorization.error.response.ApiErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthorizationErrorHandler {

    @ExceptionHandler(IncomingApiException.class)
    public ResponseEntity handleBypassApiException(IncomingApiException ex) {
        return ResponseEntity.status(ex.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiErrorResponse(ex.getCode(), ex.getMessage()));
    }

}
