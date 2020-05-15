package com.rider.elibrary.authorization.config.component;

import com.rider.elibrary.authorization.model.CustomUserAuthModel;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        CustomUserAuthModel user = (CustomUserAuthModel) authentication.getPrincipal();
        Map<String, Object> additionalClaims = new HashMap<>();
        additionalClaims.put("user_id", user.getId());
        additionalClaims.put("user_role", user.getRole().name());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalClaims);
        return super.enhance(accessToken, authentication);
    }
}
