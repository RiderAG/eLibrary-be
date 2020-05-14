package com.rider.elibrary.authorization.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthModelResponse {

    private String id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private String role;

}
