package org.universiapolis.fablab.pfe.notificationservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "spring.cloud.consul.enabled=false",
                "spring.cloud.config.enabled=false",
                "spring.rabbitmq.listener.auto-startup=false" // Disable RabbitMQ in tests
        }
)
class NotificationServiceApplicationTests {

    @Test
    void contextLoads() {
    }
}
