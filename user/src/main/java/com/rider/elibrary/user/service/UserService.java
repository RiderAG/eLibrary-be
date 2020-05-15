package com.rider.elibrary.user.service;

import com.rider.elibrary.user.model.UserAuthModel;
import com.rider.elibrary.user.model.request.RegistrationRequest;

public interface UserService {

    UserAuthModel getByUsername(String username);

    String register(RegistrationRequest request);

}
