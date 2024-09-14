package com.communicators.welltalk.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblassignedCounselor")
public class AssignedCounselorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assigned_counselor_id")
    private int assignedCounselorId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "counselor_id")
    private int counselorId;

    @Column(name = "program")
    private String program;

    @Column(name = "year")
    private int year;

    @Column(name = "college")
    private String college;

    // Getters and Setters
    public int getAssignedCounselorId() {
        return assignedCounselorId;
    }

    public void setAssignedCounselorId(int assignedCounselorId) {
        this.assignedCounselorId = assignedCounselorId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCounselorId() {
        return counselorId;
    }

    public void setCounselorId(int counselorId) {
        this.counselorId = counselorId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
