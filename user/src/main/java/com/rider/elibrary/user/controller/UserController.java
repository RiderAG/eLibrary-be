package com.rider.elibrary.user.controller;

import com.rider.elibrary.user.model.UserAuthModel;
import com.rider.elibrary.user.model.request.RegistrationRequest;
import com.rider.elibrary.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity securedResource(@AuthenticationPrincipal Jwt jwt) {
        StringBuilder sb = new StringBuilder();
        jwt.getClaims().forEach((k, v) -> sb.append("\t")
                .append(k).append(": ").append(v).append(System.lineSeparator())
        );
        return ResponseEntity.ok(
                String.format("Secured Admin Resource\r\nClaims:\r\n%s", sb.toString())
        );
    }

    @GetMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public UserAuthModel getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(RegistrationRequest request) {
        return userService.register(request);
    }

}
