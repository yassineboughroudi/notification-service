package org.universiapolis.fablab.pfe.notificationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request body for sending a notification")
public class NotificationRequest {

    @Schema(description = "Recipient email address", example = "user@example.com")
    private String recipientEmail;

    @Schema(description = "Email subject", example = "Welcome to our service")
    private String subject;

    @Schema(description = "Email message body", example = "Hello, welcome to our platform!")
    private String message;
}
