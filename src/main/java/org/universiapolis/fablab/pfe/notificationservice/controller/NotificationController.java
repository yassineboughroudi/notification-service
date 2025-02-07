package org.universiapolis.fablab.pfe.notificationservice.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universiapolis.fablab.pfe.notificationservice.dto.NotificationRequest;
import org.universiapolis.fablab.pfe.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(request);
        return ResponseEntity.ok("Notification sent successfully.");
    }
}
