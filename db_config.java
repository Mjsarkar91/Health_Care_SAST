package com.healthcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/healthcare");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    public String getUnsafeQuery() {
        String userId = "123";
        String query = "SELECT * FROM users WHERE user_id = " + userId;
        return query;
    }
}
