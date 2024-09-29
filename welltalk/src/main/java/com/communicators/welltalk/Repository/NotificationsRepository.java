package com.communicators.welltalk.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.communicators.welltalk.Entity.NotificationsEntity;

@Repository
public interface NotificationsRepository extends JpaRepository<NotificationsEntity, Integer> {
    Optional<NotificationsEntity> findByNotificationId(Long id);

    // List<NotificationsEntity> findByUser(UserEntity user);

    // List<NotificationsEntity> findByUserOrderByDateDesc(UserEntity user);

}
