package com.example.emsui2.Controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class AccessTokenConfig {

    public static String getToken() {

        //we can create this method in controller but if we redirect to some other endpoint then we need to define again

        OAuth2AuthenticationDetails auth2AuthenticationDetails = (OAuth2AuthenticationDetails) SecurityContextHolder
                .getContextHolderStrategy().getContext()
                .getAuthentication().getDetails();

        return auth2AuthenticationDetails.getTokenType()
                .concat(" ")
                .concat(auth2AuthenticationDetails.getTokenValue());
    }

    static String getPrincipalName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    static boolean getAuthorities(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"));
    }
}
