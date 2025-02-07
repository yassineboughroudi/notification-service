package org.universiapolis.fablab.pfe.notificationservice.service;


import org.universiapolis.fablab.pfe.notificationservice.dto.NotificationRequest;

public interface NotificationService {
    void sendNotification(NotificationRequest request);
}
