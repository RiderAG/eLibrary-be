package com.rider.elibrary.catalog.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest {

    private String name;
    private String author;
    private String publisher;
    private String category;
    private int year;
    private BigDecimal price;
    private int pages;

}
