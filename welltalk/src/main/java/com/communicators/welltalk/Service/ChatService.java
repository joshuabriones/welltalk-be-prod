package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.communicators.welltalk.Entity.ChatEntity;
import com.communicators.welltalk.Repository.ChatRepository;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public ChatEntity saveMessage(ChatEntity message ) {
        return chatRepository.save(message);
    }

    public List<ChatEntity> getMessages(int senderId, int receiverId) {
        return chatRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }
}
