package com.rider.elibrary.authorization.service;

import com.rider.elibrary.authorization.api.UserApi;
import com.rider.elibrary.authorization.api.response.UserAuthModelResponse;
import com.rider.elibrary.authorization.model.CustomUserAuthModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserApi userApi;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserAuthModelResponse userAuthModel = userApi.getUserByUsername(username);
        return new CustomUserAuthModel(userAuthModel.getId(),
                userAuthModel.getUsername(),
                userAuthModel.getPassword(),
                userAuthModel.getAuthorities());
    }
}
