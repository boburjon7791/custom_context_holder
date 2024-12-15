package com.example.custom_context_holder.base.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server Url")})
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("My REST API")
                .description("Some custom description of API.")
                .version("1.0").contact(new Contact().name("Soliyev Boburjon")
                        .email("soliyevboburjon95@@gmail.com").url("http://localhost:8080"))
                .license(new License().name("License of API")
                        .url("API license URL")));
    }

    /*@Bean
    public SecurityScheme createAPIKeySchema(){
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }*/
}
