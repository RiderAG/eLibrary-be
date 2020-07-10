package com.rider.elibrary.catalog.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    PROGRAMMING, COOKING, LITERATURE, HISTORY, ROMANCE;

    public static Category getByName(String name) {
        for (Category category : values()) {
            if (category.name().equalsIgnoreCase(name)) {
                return category;
            }
        }
        return null;
    }

    public static List<String> getAllNames() {
        return Arrays.stream(Category.values())
                .map(Category::name)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

}
