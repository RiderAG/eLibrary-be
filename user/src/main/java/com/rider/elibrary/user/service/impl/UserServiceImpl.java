package com.rider.elibrary.user.service.impl;

import com.rider.elibrary.user.entity.User;
import com.rider.elibrary.user.model.UserAuthModel;
import com.rider.elibrary.user.repository.UserRepository;
import com.rider.elibrary.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserAuthModel getByUsername(String username) {
        return UserAuthModel.from(userRepository.findByUsername(username));
    }

    @Override
    public String register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("user");
        user = userRepository.save(user);
        return user.getId();
    }

}
