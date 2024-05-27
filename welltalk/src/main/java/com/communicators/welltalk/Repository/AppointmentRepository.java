package com.communicators.welltalk.Repository;

import com.communicators.welltalk.Entity.AppointmentEntity;
import com.communicators.welltalk.Entity.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    List<AppointmentEntity> findByIsDeletedFalse();

    Optional<AppointmentEntity> findByAppointmentIdAndIsDeletedFalse(int id);

    List<AppointmentEntity> findByAppointmentDateAndIsDeletedFalse(LocalDate date);

    List<AppointmentEntity> findByStudentAndIsDeletedFalse(StudentEntity student);

    Boolean existsByAppointmentDateAndAppointmentStartTimeAndIsDeletedFalse(LocalDate date, String startTime);
}
