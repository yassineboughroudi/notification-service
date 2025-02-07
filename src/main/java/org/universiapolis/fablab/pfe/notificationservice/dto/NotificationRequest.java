package org.universiapolis.fablab.pfe.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private String recipientEmail;
    private String subject;
    private String message;
}
