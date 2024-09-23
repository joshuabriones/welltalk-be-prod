package com.communicators.welltalk.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Entity.ChatEntity;
import com.communicators.welltalk.Service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ResponseEntity<ChatEntity> sendMessage(@RequestBody ChatEntity message) {
        message.setTimestamp(LocalDateTime.now());
        ChatEntity savedMessage = chatService.saveMessage(message);
        return new ResponseEntity<>(savedMessage, HttpStatus.OK);
    }

    @GetMapping("/messages/{senderId}/{receiverId}")
    public ResponseEntity<List<ChatEntity>> getMessages(@PathVariable int senderId, @PathVariable int receiverId) {
        List<ChatEntity> messages = chatService.getMessages(senderId, receiverId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatEntity broadcastMessage(ChatEntity message) {
        message.setTimestamp(LocalDateTime.now());
        return chatService.saveMessage(message);
    }
}
