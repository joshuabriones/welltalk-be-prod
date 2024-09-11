package com.communicators.welltalk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Entity.AssignedCounselorEntity;
import com.communicators.welltalk.Service.AssignedCounselorService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/assignCounselor")
public class AssignedCounselorController {

    @Autowired
    private AssignedCounselorService assignedCounselorService;

    @GetMapping("/getByCounselorId/{counselorId}")
    public ResponseEntity<List<AssignedCounselorEntity>> getByCounselorId(@PathVariable int counselorId) {
        List<AssignedCounselorEntity> assignedCounselors = assignedCounselorService.getByCounselorId(counselorId);
        if (assignedCounselors != null && !assignedCounselors.isEmpty()) {
            return new ResponseEntity<>(assignedCounselors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
