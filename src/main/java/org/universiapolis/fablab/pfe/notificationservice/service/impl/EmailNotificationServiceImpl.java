package org.universiapolis.fablab.pfe.notificationservice.service.impl;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.universiapolis.fablab.pfe.notificationservice.dto.NotificationRequest;
import org.universiapolis.fablab.pfe.notificationservice.model.Notification;
import org.universiapolis.fablab.pfe.notificationservice.repository.NotificationRepository;
import org.universiapolis.fablab.pfe.notificationservice.service.NotificationService;

@Service
@RequiredArgsConstructor
public class EmailNotificationServiceImpl implements NotificationService {

    private final JavaMailSender mailSender;
    private final NotificationRepository notificationRepository;

    @Override
    public void sendNotification(NotificationRequest request) {
        // Attempt to send the email
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(request.getRecipientEmail());
            helper.setSubject(request.getSubject());
            helper.setText(request.getMessage(), true);
            mailSender.send(message);
        } catch (Exception emailEx) {
            // Log the email sending failure but continue processing
            emailEx.printStackTrace();
        }

        // Save the notification in the database regardless of email sending result
        try {
            Notification notification = Notification.builder()
                    .recipientEmail(request.getRecipientEmail())
                    .subject(request.getSubject())
                    .message(request.getMessage())
                    .sent(true)
                    .build();
            notificationRepository.save(notification);
        } catch (Exception dbEx) {
            // Log any database issues
            dbEx.printStackTrace();
            System.err.println("Database save failed: " + dbEx.getMessage());
        }
    }

}