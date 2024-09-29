package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.AppointmentEntity;
import com.communicators.welltalk.Entity.NotificationsEntity;
import com.communicators.welltalk.Entity.UserEntity;
import com.communicators.welltalk.Repository.NotificationsRepository;
import com.communicators.welltalk.dto.NotificationsDTO;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    // public List<NotificationsEntity> getAllNotifications() {
    //     return notificationsRepository.findAll();
    // }

    // public NotificationsEntity saveNotification(String message, int userId, String type) {
    //     UserEntity user = userService.getUserById(userId);
    //     NotificationsEntity notification = new NotificationsEntity(message, user, type);
    //     notification.setUser(user);

    //     return notificationsRepository.save(notification);
    // }

    // public void markAsRead(Long id) {
    //     NotificationsEntity notification = notificationsRepository.findByNotificationId(id)
    //             .orElseThrow(() -> new RuntimeException("Notification not found"));
    //     notification.setRead(true);
    //     notificationsRepository.save(notification);
    // }

    // Create
    public NotificationsEntity createAppointmentNotification(int senderId, NotificationsDTO notificationDetails) {
        String type = "appointment";
        UserEntity sender = userService.getUserById(senderId);
        UserEntity receiver = userService.getUserById(notificationDetails.getReceiverId());
        AppointmentEntity appointment = appointmentService.getAppointmentByAppointmentId(notificationDetails.getAppointmentId());

        NotificationsEntity notification = new NotificationsEntity(type, sender, receiver, appointment);
        return notificationsRepository.save(notification);
    }


    // Read
    // public List<NotificationsEntity> getNotificationsForUser(int userId) {
    //     UserEntity user = userService.getUserById(userId);
    //     return notificationsRepository.findByUser(user);
    // }

}
