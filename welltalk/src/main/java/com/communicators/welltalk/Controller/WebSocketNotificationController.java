package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.communicators.welltalk.Service.WebSocketNotificationService;

@Controller
@RequestMapping("/ws")
public class WebSocketNotificationController {

    @Autowired
    private WebSocketNotificationService webSocketNotificationService;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam String message) {
        webSocketNotificationService.sendNotification(message);
        return new ResponseEntity<>("Notification sent successfully", HttpStatus.OK);
    }

}
