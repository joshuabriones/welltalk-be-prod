package com.communicators.welltalk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.NotificationsEntity;
import com.communicators.welltalk.Entity.UserEntity;
import com.communicators.welltalk.Repository.NotificationsRepository;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Autowired
    private UserService userService;

    public List<NotificationsEntity> getAllNotifications() {
        return notificationsRepository.findAll();
    }

    public List<NotificationsEntity> getNotificationsForUser(int userId) {
        UserEntity user = userService.getUserById(userId);
        return notificationsRepository.findByUser(user);
    }

    public NotificationsEntity saveNotification(String message, int userId, String type) {
        UserEntity user = userService.getUserById(userId);
        NotificationsEntity notification = new NotificationsEntity(message, user, type);
        notification.setUser(user);

        return notificationsRepository.save(notification);
    }

    public void markAsRead(Long id) {
        NotificationsEntity notification = notificationsRepository.findByNotificationId(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationsRepository.save(notification);
    }

    public NotificationsEntity createNotification(int userId, NotificationsEntity notificationDetails) {
        // Retrieve the user by userId
        UserEntity user = userService.getUserById(userId);
        
        // Create a new NotificationsEntity using the notification details and user
        NotificationsEntity notification = new NotificationsEntity(notificationDetails.getMessage(), notificationDetails.getType(), user);
        
        // Save the notification entity
        return notificationsRepository.save(notification);
    }

}
