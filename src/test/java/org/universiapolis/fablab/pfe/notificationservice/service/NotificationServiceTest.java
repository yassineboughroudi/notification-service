package org.universiapolis.fablab.pfe.notificationservice.service.impl;

import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.universiapolis.fablab.pfe.notificationservice.dto.NotificationRequest;
import org.universiapolis.fablab.pfe.notificationservice.model.Notification;
import org.universiapolis.fablab.pfe.notificationservice.repository.NotificationRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private NotificationRepository notificationRepository;

    @InjectMocks
    private EmailNotificationServiceImpl notificationService;

    @Test
    public void testSendNotification_Success() throws Exception {
        // Given: Create a sample notification request
        NotificationRequest request = new NotificationRequest(
                "test@example.com",
                "Test Subject",
                "Test Message"
        );

        // When: Prepare a dummy MimeMessage and stub the mailSender behavior
        MimeMessage mimeMessage = Mockito.mock(MimeMessage.class);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

        // Execute the service method
        notificationService.sendNotification(request);

        // Then: Verify that the mailSender and repository methods are called
        verify(mailSender, times(1)).send(any(MimeMessage.class));
        verify(notificationRepository, times(1)).save(any(Notification.class));
    }
}
