package org.universiapolis.fablab.pfe.notificationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universiapolis.fablab.pfe.notificationservice.dto.NotificationRequest;
import org.universiapolis.fablab.pfe.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@Tag(name = "Notification API", description = "Endpoints for sending notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/send")
    @Operation(summary = "Send an email notification", description = "Sends an email to a recipient")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(request);
        return ResponseEntity.ok("Notification sent successfully!");
    }
}
