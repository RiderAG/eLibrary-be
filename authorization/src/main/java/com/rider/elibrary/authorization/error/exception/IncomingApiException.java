package com.rider.elibrary.authorization.error.exception;

import org.springframework.http.HttpStatus;

public class IncomingApiException extends RuntimeException {

    private HttpStatus httpStatus;
    private String code;

    public IncomingApiException(String message, HttpStatus httpStatus, String code) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

}
