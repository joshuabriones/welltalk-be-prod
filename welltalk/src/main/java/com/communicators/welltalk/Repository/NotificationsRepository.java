package com.communicators.welltalk.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.communicators.welltalk.Entity.NotificationsEntity;
import com.communicators.welltalk.Entity.UserEntity;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationsRepository extends JpaRepository<NotificationsEntity, Integer> {
    Optional<NotificationsEntity> findById(Long id);

    List<NotificationsEntity> findByUser(UserEntity user);

    List<NotificationsEntity> findByUserOrderByDateDescTimeDesc(UserEntity user);

}
