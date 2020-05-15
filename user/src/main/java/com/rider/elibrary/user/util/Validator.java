package com.rider.elibrary.user.util;

import com.rider.elibrary.user.error.exception.ErrorModel;
import com.rider.elibrary.user.error.exception.UserApiException;
import com.rider.elibrary.user.model.request.RegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    private static final String USERNAME_PATTERN = "^[A-Za-z0-9_]{5,20}$";
    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9_]{8,20}$";

    public void validateRequest(RegistrationRequest request) {
        validateUsername(request.getUsername());
        validateEmail(request.getEmail());
        validatePassword(request.getPassword());
    }

    private void validateUsername(String username) {
        if (!username.matches(USERNAME_PATTERN)) {
            throw new UserApiException("Invalid username", ErrorModel.INVALID_REGISTRATION_REQUEST);
        }
    }

    private void validateEmail(String email) {
        if (!email.matches(EMAIL_PATTERN)) {
            throw new UserApiException("Invalid email", ErrorModel.INVALID_REGISTRATION_REQUEST);
        }
    }

    private void validatePassword(String password) {
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new UserApiException("Invalid password", ErrorModel.INVALID_REGISTRATION_REQUEST);
        }
    }

}
