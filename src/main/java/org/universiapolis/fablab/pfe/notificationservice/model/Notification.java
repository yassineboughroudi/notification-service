package org.universiapolis.fablab.pfe.notificationservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipientEmail;
    private String subject;
    private String message;
    private boolean sent;
}
