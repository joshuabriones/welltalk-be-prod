package com.communicators.welltalk.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.communicators.welltalk.Entity.JournalEntity;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntity, Integer> {
    List<JournalEntity> findByIsDeletedFalse();

    JournalEntity findByJournalIdAndIsDeletedFalse(int id);

    List<JournalEntity> findByStudentIdAndIsDeletedFalse(int id);
}
