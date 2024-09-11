package com.communicators.welltalk.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.AssignedCounselorEntity;
import com.communicators.welltalk.Entity.CounselorEntity;
import com.communicators.welltalk.Entity.StudentEntity;
import com.communicators.welltalk.Entity.TeacherEntity;
import com.communicators.welltalk.Entity.UserEntity;
import com.communicators.welltalk.Repository.AssignedCounselorRepository;
import com.communicators.welltalk.Repository.CounselorRepository;
import com.communicators.welltalk.Repository.StudentRepository;
import com.communicators.welltalk.Repository.TeacherRepository;

@Service
public class AssignedCounselorService {

    @Autowired
    CounselorRepository counselorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    AssignedCounselorRepository assignedCounselorRepository;

    public void assignCounselorIfVerified(UserEntity user) {
        if (user.getIsVerified()) {
            if (user instanceof StudentEntity) {
                StudentEntity student = (StudentEntity) user;
                List<CounselorEntity> counselors = counselorRepository.findByIsDeletedFalse();
                for (CounselorEntity counselor : counselors) {
                    if (counselor.getProgram().equals(student.getProgram()) ||
                            counselor.getCollege().equals(student.getCollege()) ||
                            counselor.getAssignedYear().equals(String.valueOf(student.getYear()))) {

                        AssignedCounselorEntity assignedCounselor = new AssignedCounselorEntity();
                        assignedCounselor.setStudentId(student.getId());
                        assignedCounselor.setCounselorId(counselor.getId());
                        assignedCounselor.setProgram(student.getProgram());
                        assignedCounselor.setYear(student.getYear());
                        assignedCounselor.setCollege(student.getCollege());

                        assignedCounselorRepository.save(assignedCounselor);
                    }
                }
            } else if (user instanceof TeacherEntity) {
                TeacherEntity teacher = (TeacherEntity) user;
                List<CounselorEntity> counselors = counselorRepository.findByIsDeletedFalse();
                for (CounselorEntity counselor : counselors) {
                    if (counselor.getProgram().equals(teacher.getProgram()) ||
                            counselor.getCollege().equals(teacher.getCollege())) {

                        AssignedCounselorEntity assignedCounselor = new AssignedCounselorEntity();
                        assignedCounselor.setTeacherId(teacher.getId());
                        assignedCounselor.setCounselorId(counselor.getId());
                        assignedCounselor.setProgram(teacher.getProgram());
                        assignedCounselor.setCollege(teacher.getCollege());

                        assignedCounselorRepository.save(assignedCounselor);
                    }
                }
            }
        }
    }

    public List<AssignedCounselorEntity> getByCounselorId(int counselorId) {
        return assignedCounselorRepository.findByCounselorId(counselorId);
    }

    public Optional<StudentEntity> getStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }

    public Optional<TeacherEntity> getTeacherById(int teacherId) {
        return teacherRepository.findById(teacherId);
    }
}
