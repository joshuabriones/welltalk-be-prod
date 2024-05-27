package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Entity.TeacherEntity;
import com.communicators.welltalk.Service.AuthenticationService;
import com.communicators.welltalk.Service.TeacherService;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/user/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/createTeacher")
    public ResponseEntity<TeacherEntity> insertTeacher(@RequestBody TeacherEntity teacher) {
        TeacherEntity newTeacher = authenticationService.registerTeacher(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/getAllTeachers")
    public ResponseEntity<List<TeacherEntity>> getAllTeachers() {
        List<TeacherEntity> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/getTeacherById/{id}")
    public ResponseEntity<TeacherEntity> getTeacherById(@PathVariable int id) {
        TeacherEntity teacher = teacherService.getTeacherById(id);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity<TeacherEntity> updateTeacher(@PathVariable int id, @RequestBody TeacherEntity teacher) {
        TeacherEntity updatedTeacher = teacherService.updateTeacher(id, teacher);
        if (updatedTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        boolean deleted = teacherService.deleteTeacher(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
