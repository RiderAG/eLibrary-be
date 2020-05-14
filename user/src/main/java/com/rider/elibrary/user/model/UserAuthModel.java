package com.rider.elibrary.user.model;

import com.rider.elibrary.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthModel {

    private String id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private String role;

    public static UserAuthModel from(User user) {
        return UserAuthModel.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(new ArrayList<>())
                .role(user.getRole())
                .build();
    }
}
