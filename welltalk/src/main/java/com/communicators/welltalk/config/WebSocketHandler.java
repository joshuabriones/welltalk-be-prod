package com.communicators.welltalk.config;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.communicators.welltalk.Entity.ChatEntity;
import com.communicators.welltalk.Service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebSocketHandler extends TextWebSocketHandler {

    private final ChatService chatService;

    public WebSocketHandler(ChatService chatService) {
        this.chatService = chatService;
    }

    @Override
    protected void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage message) throws Exception {
        String payload = message.getPayload();
        ChatEntity chatMessage = new ObjectMapper().readValue(payload, ChatEntity.class);
        chatMessage.setTimestamp(LocalDateTime.now());
        chatService.saveMessage(chatMessage);
        session.sendMessage(new TextMessage("Response from server: " + payload));
    }
}
