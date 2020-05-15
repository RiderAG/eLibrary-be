package com.rider.elibrary.authorization.error.exception;

public class ApiException extends RuntimeException {

    private ErrorModel errorModel;

    public ApiException(String message, ErrorModel errorModel) {
        super(message);
        this.errorModel = errorModel;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

}
