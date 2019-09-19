package com.example.demo.Controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter{

    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @RequestMapping(value = "/")
    public  String loadHome(){
        return "index";
    }

    @RequestMapping(value = "/report")
    public  String loadreport(){
        return "home";
    }
}