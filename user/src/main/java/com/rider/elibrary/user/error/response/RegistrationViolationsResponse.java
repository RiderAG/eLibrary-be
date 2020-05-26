package com.rider.elibrary.user.error.response;

import java.util.List;

public class RegistrationViolationsResponse {

    private String code;
    private List<String> violations;

    public RegistrationViolationsResponse(String code, List<String> violations) {
        this.code = code;
        this.violations = violations;
    }

    public String getCode() {
        return code;
    }

    public List<String> getViolations() {
        return violations;
    }
}
