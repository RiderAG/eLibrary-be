package com.rider.elibrary.catalog.error.exception;

import org.springframework.http.HttpStatus;

public enum ErrorModel {

    INCORRECT_CREATE_BOOK_REQUEST(HttpStatus.BAD_REQUEST, "incorrect.create.book.request"),
    CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "category.not.found");

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
