package com.example.jdbctemplate.configuation;

import com.example.jdbctemplate.repository.CustomerRepository;
import com.example.jdbctemplate.repository.JdbcTemplateCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateAppConfig {

    private final DataSource dataSource;
    @Bean
    CustomerRepository customerRepository() {
        return new JdbcTemplateCustomerRepository(dataSource);
    }
}
