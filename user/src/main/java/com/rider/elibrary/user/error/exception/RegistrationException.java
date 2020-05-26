package com.rider.elibrary.user.error.exception;

import java.util.List;

public class RegistrationException extends UserApiException {

    private List<String> violations;

    public RegistrationException(String message, ErrorModel errorModel, List<String> violations) {
        super(message, errorModel);
        this.violations = violations;
    }

    public List<String> getViolations() {
        return violations;
    }
}
