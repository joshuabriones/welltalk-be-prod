package com.communicators.welltalk.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tblcounselor")
public class CounselorEntity extends UserEntity {

    public CounselorEntity() {

    }

    public CounselorEntity(String institutionalEmail, String idNumber, String firstName, String lastName, String gender,
            String password, String image, String role) {
        super(institutionalEmail, idNumber, firstName, lastName, gender, password, image, role);
    }

    public CounselorEntity(int teacherId, String institutionalEmail, String idNumber, String firstName, String lastName,
            String gender, String password, String role) {
        super(institutionalEmail, idNumber, firstName, lastName, gender, password, role);
    }
}
