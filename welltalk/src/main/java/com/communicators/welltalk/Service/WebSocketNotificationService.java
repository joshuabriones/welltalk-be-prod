package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketNotificationService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void sendNotification(String message) {
        System.out.print("Sending notification: " + message);
        simpMessagingTemplate.convertAndSend("/topic/notification", message);
    }

}
