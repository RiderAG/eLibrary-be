package com.rider.elibrary.catalog.error.response;

public class ApiExceptionResponse {

    private String code;
    private String message;

    public ApiExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
