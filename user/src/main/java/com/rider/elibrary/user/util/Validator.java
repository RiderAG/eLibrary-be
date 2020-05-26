package com.rider.elibrary.user.util;

import com.rider.elibrary.user.error.exception.ErrorModel;
import com.rider.elibrary.user.error.exception.RegistrationException;
import com.rider.elibrary.user.model.Gender;
import com.rider.elibrary.user.model.request.RegistrationRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Validator {

    private static final String USERNAME_PATTERN = "^[A-Za-z0-9_]{4,20}$";
    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9_]{8,20}$";
    private static final String NAME_PATTERN = "^\\S{2,50}$";

    public void validateRequest(RegistrationRequest request) {
        List<String> violations = new ArrayList<>();
        validateUsername(violations, request.getUsername());
        validateEmail(violations, request.getEmail());
        validateFirstName(violations, request.getFirstName());
        validateLastName(violations, request.getLastName());
        validateBirthDate(violations, request.getBirthDate());
        validateGender(violations, request.getGender());
        validateCountry(violations, request.getCountry());
        validatePassword(violations, request.getPassword(), request.getPasswordConfirm());
        if (!violations.isEmpty()) {
            throw new RegistrationException("Invalid registration request", ErrorModel.INVALID_REGISTRATION_REQUEST, violations);
        }
    }

    private void validateUsername(List<String> violations, String username) {
        if (!username.matches(USERNAME_PATTERN)) {
            violations.add("Incorrect username");
        }
    }

    private void validateEmail(List<String> violations, String email) {
        if (!email.matches(EMAIL_PATTERN)) {
            violations.add("Incorrect email");
        }
    }

    private void validateFirstName(List<String> violations, String firstName) {
        if (!firstName.matches(NAME_PATTERN)) {
            violations.add("Incorrect first name");
        }
    }

    private void validateLastName(List<String> violations, String lastName) {
        if (!lastName.matches(NAME_PATTERN)) {
            violations.add("Incorrect last name");
        }
    }

    private void validateBirthDate(List<String> violations, String birthDate) {
        try {
            LocalDate.parse(birthDate, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException ex) {
            violations.add("Incorrect birth date");
        }
    }

    private void validateGender(List<String> violations, String gender) {
        if (Objects.isNull(Gender.valueByName(gender))) {
            violations.add("Incorrect gender");
        }
    }

    private void validateCountry(List<String> violations, String country) {
        if (Objects.isNull(country)) {
            violations.add("Incorrect country");
        }
    }

    private void validatePassword(List<String> violations, String password, String passwordConfirm) {
        if (!password.matches(PASSWORD_PATTERN) || !passwordConfirm.matches(PASSWORD_PATTERN)) {
            violations.add("Incorrect password");
        }
        if (!password.equals(passwordConfirm)) {
            violations.add("Passwords don't match");
        }
    }

}
