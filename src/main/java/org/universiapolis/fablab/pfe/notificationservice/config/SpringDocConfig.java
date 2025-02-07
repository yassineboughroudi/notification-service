package org.universiapolis.fablab.pfe.notificationservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI notificationServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Notification Microservice API")
                        .description("API for sending email notifications")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Yassine")
                                .email("")));
    }
}
