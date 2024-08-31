package com.vladproductions.playersdocapiswagger;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "players-doc-api-swagger",
				description = "documentation-api (SWAGGER-UI): players data service",
				version = "v1.0",
				contact = @Contact(
						name = "vladproduction",
						email = "vladproduction@gmail.com",
						url = "https://github.com/vladproduction"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/vladproduction/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "SpringBoot Players Management Documentation (players, leagues, countries, clubs)",
				url = "https://github.com/vladproduction/user_management.html"
		)
)
public class PlayersDocApiSwaggerApplication {

	public static void main(String[] args) {

		SpringApplication.run(PlayersDocApiSwaggerApplication.class, args);

	}

}
