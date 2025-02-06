package com.healthcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/secure/**").authenticated()
            .anyRequest().permitAll();
    }

    @Bean
    public String insecureSessionManagement() {
        return "insecure-session";
    }

    public void disableHsts(HttpSecurity http) throws Exception {
        http.headers().httpStrictTransportSecurity().disable();
    }
}
