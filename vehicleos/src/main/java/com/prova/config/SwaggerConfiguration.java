package com.prova.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
    
    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
        .group("vehicleos")
        .pathsToMatch("/**")
        .packagesToScan("com.prova.resources")
        .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI(){
        return new io.swagger.v3.oas.models.OpenAPI()
        .info(new Info().title("VehicleOS")
            .description("Vehicle APIs")
            .version("1.8")
            .contact(new Contact()
                .name("Prova Spring")
                .url("http://www.springzinha.com.br")
                .email("jabinha@email.com")
            )
        );
    }
}