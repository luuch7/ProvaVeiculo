package com.prova.services;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jakarta.annotation.PostConstruct;


@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @PostConstruct
    public void initDB() {
        if (value.equals("create")) {
            this.dbService.initDB();
        }
    }

}