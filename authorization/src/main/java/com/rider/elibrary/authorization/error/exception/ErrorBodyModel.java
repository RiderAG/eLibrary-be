package com.rider.elibrary.authorization.error.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorBodyModel {

    private String code;
    private String message;

}
