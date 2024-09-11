package com.communicators.welltalk.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tblcounselor")
public class CounselorEntity extends UserEntity {
    @Column(name = "college")
    private String college;

    @Column(name = "programs")
    private String programs;

    @Column(name = "yearLevels")
    private String yearLevels;


    public CounselorEntity() {

    }

    public CounselorEntity(String institutionalEmail, String idNumber, String firstName, String lastName, String gender,
            String password, String image, String role, String college, String programs, String yearLevels) {
        super(institutionalEmail, idNumber, firstName, lastName, gender, password, image, role);
        this.college = college;
        this.programs = programs;
        this.yearLevels = yearLevels;
    }

    public CounselorEntity(int teacherId, String institutionalEmail, String idNumber, String firstName, String lastName,
            String gender, String password, String role, String college, String programs, String yearLevels) {
        super(institutionalEmail, idNumber, firstName, lastName, gender, password, role);
        this.college = college;
        this.programs = programs;
        this.yearLevels = yearLevels;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollege() {
        return college;
    }

    public void setPrograms(String programs) {
        this.programs = programs;
    }

    public String getPrograms() {
        return programs;
    }

    public void setYearLevels(String yearLevels) {
        this.yearLevels = yearLevels;
    }

    public String getYearLevels() {
        return yearLevels;
    }
}
