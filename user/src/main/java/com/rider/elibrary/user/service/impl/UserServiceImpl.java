package com.rider.elibrary.user.service.impl;

import com.rider.elibrary.user.entity.User;
import com.rider.elibrary.user.error.exception.ErrorModel;
import com.rider.elibrary.user.error.exception.UserApiException;
import com.rider.elibrary.user.model.UserAuthModel;
import com.rider.elibrary.user.model.request.RegistrationRequest;
import com.rider.elibrary.user.repository.UserRepository;
import com.rider.elibrary.user.service.UserService;
import com.rider.elibrary.user.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Override
    public User getById(String userId) {
        if (Objects.isNull(userId)) {
            throw new UserApiException("User id is null", ErrorModel.USER_NOT_FOUND);
        }
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserApiException("User not found", ErrorModel.USER_NOT_FOUND));
    }

    @Override
    public UserAuthModel getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new UserApiException("Bad credentials", ErrorModel.USER_NOT_FOUND);
        }
        return UserAuthModel.from(user);
    }

    @Override
    public String register(RegistrationRequest request) {
        if (userExists(request)) {
            throw new UserApiException("User already exists", ErrorModel.USER_ALREADY_EXISTS);
        }
        validator.validateRequest(request);
        User user = User.from(request);
        encodeUserPassword(user);
        user = userRepository.save(user);
        return user.getId();
    }

    private boolean userExists(RegistrationRequest request) {
        if (Objects.nonNull(userRepository.findByUsername(request.getUsername()))) {
            return true;
        }
        return Objects.nonNull(userRepository.findByEmail(request.getEmail()));
    }

    private void encodeUserPassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
