package com.communicators.welltalk.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.communicators.welltalk.Entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findByIsDeletedFalse();

    Optional<PostEntity> findByPostIdAndIsDeletedFalse(int id);
}
