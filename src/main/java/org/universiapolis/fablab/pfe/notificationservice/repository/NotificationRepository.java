package org.universiapolis.fablab.pfe.notificationservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.universiapolis.fablab.pfe.notificationservice.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
