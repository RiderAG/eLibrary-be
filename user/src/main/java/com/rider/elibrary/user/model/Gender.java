package com.rider.elibrary.user.model;

public enum Gender {
    MALE, FEMALE;

    public static Gender valueByName(String value) {
        for (Gender gender : values()) {
            if (gender.name().equalsIgnoreCase(value)) {
                return gender;
            }
        }
        return null;
    }
}
