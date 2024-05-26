package com.communicators.welltalk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.communicators.welltalk.Entity.TeacherEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {
    List<TeacherEntity> findByIsDeletedFalse();

    Optional<TeacherEntity> findByIdAndIsDeletedFalse(int id);

    Optional<TeacherEntity> findByInstitutionalEmailAndIsDeletedFalse(String institutionalEmail);
}