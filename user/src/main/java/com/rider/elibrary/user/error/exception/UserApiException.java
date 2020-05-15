package com.rider.elibrary.user.error.exception;

public class UserApiException extends RuntimeException {

    private ErrorModel errorModel;

    public UserApiException(String message, ErrorModel errorModel) {
        super(message);
        this.errorModel = errorModel;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

}
