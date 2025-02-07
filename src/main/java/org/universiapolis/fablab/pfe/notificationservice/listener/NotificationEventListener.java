package org.universiapolis.fablab.pfe.notificationservice.listener;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.universiapolis.fablab.pfe.notificationservice.dto.NotificationRequest;
import org.universiapolis.fablab.pfe.notificationservice.service.NotificationService;

@Component
@RequiredArgsConstructor
public class NotificationEventListener {

    private final NotificationService notificationService;

    @RabbitListener(queues = "notification.queue")
    public void handleNotificationEvent(NotificationRequest request) {
        notificationService.sendNotification(request);
    }
}
