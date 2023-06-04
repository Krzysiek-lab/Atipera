package com.example.atipera.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {
    @Bean
    public OpenAPI ServerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Atipera")
                        .version("v0.0.1")
                        .description("Zadanie próbne"));
    }
}
