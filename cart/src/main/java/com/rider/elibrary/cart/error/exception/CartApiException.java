package com.rider.elibrary.cart.error.exception;

public class CartApiException extends RuntimeException {

    private ErrorModel errorModel;

    public CartApiException(String message, ErrorModel errorModel) {
        super(message);
        this.errorModel = errorModel;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

}
