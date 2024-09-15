package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.communicators.welltalk.Service.NotificationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @GetMapping("/getAllNotifications")
    public ResponseEntity<?> getAllNotifications() {
        return new ResponseEntity<>(notificationsService.getAllNotifications(), HttpStatus.OK);
    }

    @GetMapping("/getNotificationsForUser")
    public ResponseEntity<?> getNotificationsForUser(@RequestParam int userId) {
        return new ResponseEntity<>(notificationsService.getNotificationsForUser(userId), HttpStatus.OK);
    }

    @PostMapping("/saveNotification")
    public ResponseEntity<?> saveNotification(@RequestParam String message, @RequestParam int userId, String type) {
        return new ResponseEntity<>(notificationsService.saveNotification(message, userId, type), HttpStatus.OK);
    }

    @PutMapping("/markAsRead")
    public ResponseEntity<?> markAsRead(@RequestParam Long id) {
        notificationsService.markAsRead(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
