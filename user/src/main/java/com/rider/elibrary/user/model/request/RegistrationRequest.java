package com.rider.elibrary.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String country;
    private String city;
    private String address;
    private String password;
    private String passwordConfirm;

}
