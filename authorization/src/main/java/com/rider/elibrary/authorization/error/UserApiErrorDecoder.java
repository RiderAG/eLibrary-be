package com.rider.elibrary.authorization.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rider.elibrary.authorization.error.exception.ApiException;
import com.rider.elibrary.authorization.error.exception.IncomingApiException;
import com.rider.elibrary.authorization.error.exception.ErrorBodyModel;
import com.rider.elibrary.authorization.error.exception.ErrorModel;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class UserApiErrorDecoder implements ErrorDecoder {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        return getIncomingApiException(methodKey, response)
                .orElse(new ApiException("Unknown exception", ErrorModel.INTERNAL_SERVER_ERROR));
    }

    private Optional<Exception> getIncomingApiException(String methodKey, Response response) {
        if (isUserApiException(methodKey)) {
            return extractApiException(response);
        }
        return Optional.empty();
    }

    private boolean isUserApiException(String methodKey) {
        return methodKey.toLowerCase().contains("user");
    }

    private Optional<Exception> extractApiException(Response response) {
        try {
            ErrorBodyModel errorBodyModel = objectMapper
                    .readValue(response.body().asReader(StandardCharsets.UTF_8), ErrorBodyModel.class);
            return Optional.of(new IncomingApiException(errorBodyModel.getMessage(),
                    HttpStatus.valueOf(response.status()),
                    errorBodyModel.getCode()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
