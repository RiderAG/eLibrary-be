package com.rider.elibrary.authorization.api;

import com.rider.elibrary.authorization.api.response.UserAuthModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user")
public interface UserApi {

    @GetMapping("/api/users/auth")
    UserAuthModelResponse getUserByUsername(@RequestParam String username);

}
