package com.rider.elibrary.authorization.error.exception;

public class AuthApiException extends ApiException {

    public AuthApiException(String message, ErrorModel errorCode) {
        super(message, errorCode);
    }

}
