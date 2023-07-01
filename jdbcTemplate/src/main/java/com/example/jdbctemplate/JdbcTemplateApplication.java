package com.example.jdbctemplate;

import com.example.jdbctemplate.configuation.AppConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;

@Import(AppConfig.class)
@SpringBootApplication
public class JdbcTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateApplication.class, args);
    }

}
