package com.communicators.welltalk.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.communicators.welltalk.Entity.ChatEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Integer> {
    List<ChatEntity> findBySenderIdAndReceiverId(int senderId, int receiverId);
}
