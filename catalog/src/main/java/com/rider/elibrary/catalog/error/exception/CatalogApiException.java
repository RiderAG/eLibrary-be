package com.rider.elibrary.catalog.error.exception;

public class CatalogApiException extends RuntimeException {

    private ErrorModel errorModel;

    public CatalogApiException(String message, ErrorModel errorModel) {
        super(message);
        this.errorModel = errorModel;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

}
