package com.rider.elibrary.authorization.error.exception;

import org.springframework.http.HttpStatus;

public enum ErrorModel {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "internal.server.error");

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

    public static ErrorModel getByCode(String code) {
        for (ErrorModel model : values()) {
            if (model.code.equalsIgnoreCase(code)) {
                return model;
            }
        }
        return null;
    }
}
