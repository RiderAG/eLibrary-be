package com.rider.elibrary.authorization.config.feign;

import com.rider.elibrary.authorization.error.UserApiErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserApiFeignConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserApiErrorDecoder();
    }

}
