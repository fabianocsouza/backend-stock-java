package com.project.backend;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jdk.nashorn.internal.runtime.Version;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	@Value("${application.description} ")
	public OpenAPI customOpenAPI(String description, @Value("${application.version}") String version){
		return new OpenAPI()
				.info(new Info()
						.title(description)
						.version(version)
						.termsOfService("http://swagger.io/terms")
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")));
	}
}
