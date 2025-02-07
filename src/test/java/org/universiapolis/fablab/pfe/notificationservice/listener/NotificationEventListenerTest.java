package org.universiapolis.fablab.pfe.notificationservice.listener;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.universiapolis.fablab.pfe.notificationservice.dto.NotificationRequest;
import org.universiapolis.fablab.pfe.notificationservice.service.NotificationService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationEventListenerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationEventListener notificationEventListener;

    @Test
    void testHandleNotificationEvent() {
        NotificationRequest request = new NotificationRequest(
                "recipient@example.com",
                "Test Subject",
                "Test Message"
        );

        notificationEventListener.handleNotificationEvent(request);

        verify(notificationService, times(1)).sendNotification(request);
    }
}
