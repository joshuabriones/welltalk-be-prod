package com.communicators.welltalk.Repository;

import com.communicators.welltalk.Entity.AppointmentEntity;
import com.communicators.welltalk.Entity.CounselorEntity;
import com.communicators.welltalk.Entity.StudentEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    List<AppointmentEntity> findByIsDeletedFalse(Sort sort);

    Optional<AppointmentEntity> findByAppointmentIdAndIsDeletedFalse(int id);

    List<AppointmentEntity> findByAppointmentDateAndIsDeletedFalse(LocalDate date);

    List<AppointmentEntity> findByStudentAndIsDeletedFalse(StudentEntity student);

    Boolean existsByAppointmentDateAndAppointmentStartTimeAndIsDeletedFalse(LocalDate date, String startTime);

    List<AppointmentEntity> findByCounselorAndAppointmentDateAndAppointmentStartTimeAndIsDeletedFalse(
            CounselorEntity counselor, LocalDate date, String startTime);
<<<<<<< HEAD

    List<AppointmentEntity> findByCounselorAndIsDeletedFalse(CounselorEntity counselor);
=======
<<<<<<< Updated upstream
=======

    List<AppointmentEntity> findByCounselorAndIsDeletedFalse(CounselorEntity counselor);
>>>>>>> Stashed changes
>>>>>>> 840f85a8743ace7b2ab5aa26711b25c159acfe85
}
