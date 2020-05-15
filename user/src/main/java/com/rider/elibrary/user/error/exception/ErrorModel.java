package com.rider.elibrary.user.error.exception;

import org.springframework.http.HttpStatus;

public enum ErrorModel {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "user.not.found"),
    INVALID_REGISTRATION_REQUEST(HttpStatus.BAD_REQUEST, "invalid.registration.request"),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "user.already.exists");

    private HttpStatus httpStatus;
    private String code;

    ErrorModel(HttpStatus httpStatus, String code) {
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
