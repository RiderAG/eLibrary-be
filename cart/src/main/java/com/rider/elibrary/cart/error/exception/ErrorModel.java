package com.rider.elibrary.cart.error.exception;

import org.springframework.http.HttpStatus;

public enum ErrorModel {

    NULL_USER_ID(HttpStatus.BAD_REQUEST, "null.user.id"),
    CART_NOT_FOUND(HttpStatus.NOT_FOUND, "cart.not.found");

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
