package com.example.BuenoPeralesJesus_pruebatec4;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BuenoPeralesJesusPruebatec4Application {

	public static void main(String[] args) {
		SpringApplication.run(BuenoPeralesJesusPruebatec4Application.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Es una Api de Agencia de viaje")
				.version("0.0.1")
				.description("Prueba de agencia de viaje"));

	}
}