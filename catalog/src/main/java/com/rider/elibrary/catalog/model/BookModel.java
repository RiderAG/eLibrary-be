package com.rider.elibrary.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    private String id;
    private String name;
    private BigDecimal price;

}
