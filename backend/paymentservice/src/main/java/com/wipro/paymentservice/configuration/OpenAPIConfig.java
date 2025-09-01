package com.wipro.paymentservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Capstone Project API")
                        .description("APIs for Flight, Booking, and Payment Services")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Capstone Team")
                                .email("support@wipro.com")));
    }
}
