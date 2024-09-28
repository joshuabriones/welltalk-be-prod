package com.communicators.welltalk.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.communicators.welltalk.Entity.ChatEntity;
import com.communicators.welltalk.Repository.ChatRepository;
import com.communicators.welltalk.Service.ChatService;

import java.util.List;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    private final ChatRepository chatMessageRepository;
    private final ChatService chatService; // Add this line

    public ChatController(ChatRepository chatMessageRepository, ChatService chatService) {
        this.chatMessageRepository = chatMessageRepository;
        this.chatService = chatService; // Initialize the service
    }

    // @GetMapping("/api/messages")
    // public List<ChatEntity> getChatMessages(@RequestParam int senderId, @RequestParam int receiverId) {
    //     return chatService.getChatHistory(senderId, receiverId);
    // }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatEntity sendMessage(ChatEntity chatMessage) {
        chatMessage.setTimestamp(LocalDateTime.now());
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }


    // !!! UNCOMMENT IF FAIL
    @GetMapping("/api/messages")
    public ResponseEntity<List<ChatEntity>> getMessages(@RequestParam int senderId, @RequestParam int receiverId) {
        List<ChatEntity> messages = chatService.getChatHistory(senderId, receiverId);
        return ResponseEntity.ok(messages);
    }
}

