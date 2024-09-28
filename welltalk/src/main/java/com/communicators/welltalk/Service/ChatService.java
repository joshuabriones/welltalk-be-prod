package com.communicators.welltalk.Service;

import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.ChatEntity;
import com.communicators.welltalk.Repository.ChatRepository;

import java.util.List;

@Service
public class ChatService {

    private final ChatRepository chatMessageRepository;

    public ChatService(ChatRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public List<ChatEntity> getChatHistory(int senderId, int receiverId) {
        // Fetch messages for both sender and receiver

        return chatMessageRepository.findChatBetweenUsers(senderId, receiverId);
    }
}
