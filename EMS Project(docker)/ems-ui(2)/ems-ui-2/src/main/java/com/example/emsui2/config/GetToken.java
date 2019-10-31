package com.example.emsui2.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class GetToken {

    public static String getToken(){
        String token= null;
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication !=null){
            token=((OAuth2AuthenticationDetails)authentication.getDetails()).getTokenValue();
        }
        return token;
    }
}
