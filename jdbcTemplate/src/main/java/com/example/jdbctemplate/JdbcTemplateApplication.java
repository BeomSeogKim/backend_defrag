package com.example.jdbctemplate;

import com.example.jdbctemplate.configuation.JdbcTemplateAppConfig;
import com.example.jdbctemplate.configuation.NamedParameterJdbcTemplateAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(JdbcTemplateAppConfig.class)
@Import(NamedParameterJdbcTemplateAppConfig.class)
@SpringBootApplication(scanBasePackages = "com.example.jdbctemplate.repository")
public class JdbcTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateApplication.class, args);
    }

}
