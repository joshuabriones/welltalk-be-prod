package com.communicators.welltalk.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.TeacherEntity;
import com.communicators.welltalk.Repository.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    AssignedCounselorService assignedCounselorService;

    public List<TeacherEntity> getAllTeachers() {
        return teacherRepository.findByIsDeletedFalse();
    }

    public TeacherEntity getTeacherById(int id) {
        return teacherRepository.findByIdAndIsDeletedFalse(id).get();
    }

    @SuppressWarnings("finally")
    public TeacherEntity updateTeacher(int id, TeacherEntity teacher) {
        TeacherEntity teacherToUpdate = new TeacherEntity();
        try {
            teacherToUpdate = teacherRepository.findByIdAndIsDeletedFalse(id).get();

            // teacherToUpdate.setInstitutionalEmail(teacher.getInstitutionalEmail());
            teacherToUpdate.setFirstName(teacher.getFirstName());
            teacherToUpdate.setLastName(teacher.getLastName());
            teacherToUpdate.setGender(teacher.getGender());
            // teacherToUpdate.setPassword(teacher.getPassword());
            teacherToUpdate.setImage(teacher.getImage());
            teacherToUpdate.setCollege(teacher.getCollege());
            teacherToUpdate.setProgram(teacher.getProgram());
            // Save updated teacher
            teacherToUpdate = teacherRepository.save(teacherToUpdate);

            // Update assignments
            assignedCounselorService.assignCounselorIfVerified(teacherToUpdate);

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Teacher " + id + " does not exist.");
        } finally {
            return teacherToUpdate;
        }
    }

    public boolean deleteTeacher(int id) {
        TeacherEntity teacher = teacherRepository.findById(id).get();
        if (teacher != null) {
            teacher.setIsDeleted(true);
            teacherRepository.save(teacher);
            return true;
        } else {
            System.out.println("Teacher " + id + " does not exist.");
            return false;
        }
    }

}
