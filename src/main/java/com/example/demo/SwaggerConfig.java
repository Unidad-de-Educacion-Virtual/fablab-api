package com.example.demo;

import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Web Backend")
            .version("v1")
            .description("REST API para gestión de asistencias en el FabLab de la UFPS"))
        	.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
        	.components(
        		new Components()
                .addSecuritySchemes(
                	"bearerAuth",
                	new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                )
            );
    }
}
