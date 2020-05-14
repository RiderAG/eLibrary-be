package com.rider.elibrary.user.service;

import com.rider.elibrary.user.model.UserAuthModel;

public interface UserService {

    UserAuthModel getByUsername(String username);

    String register(String username, String password);

}
