package com.prova.vehicleos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.prova.domains", "com.prova.domains.enums"})
@ComponentScan(basePackages = "com.prova")
@EnableJpaRepositories(basePackages = "com.prova.repositories")
@SpringBootApplication
public class VehicleosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleosApplication.class, args);
	}

	//teste
	//seu pai e lindo
}
