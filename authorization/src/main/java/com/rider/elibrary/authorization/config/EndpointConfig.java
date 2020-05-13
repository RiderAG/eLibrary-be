package com.rider.elibrary.authorization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;

@Order(1)
@Configuration
class EndpointConfig extends AuthorizationServerSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http
                .requestMatchers()
                .mvcMatchers("/oauth/public")
                .and()
                .authorizeRequests()
                .mvcMatchers("/oauth/public").permitAll();
    }
}
