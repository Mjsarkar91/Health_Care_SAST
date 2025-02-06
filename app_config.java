package com.healthcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.healthcare")
public class ApplicationConfig implements WebMvcConfigurer {

    @Bean
    public String enableHttps() {
        return "force-https";
    }

    @Bean
    public String insecureCors() {
        return "*";
    }
}
