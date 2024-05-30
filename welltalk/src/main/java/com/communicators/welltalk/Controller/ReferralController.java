package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.communicators.welltalk.Service.ReferralService;
import com.communicators.welltalk.Entity.ReferralEntity;

import java.util.List;

@RestController
@RequestMapping("/user/referral")
public class ReferralController {

    @Autowired
    private ReferralService referralService;

    @GetMapping("/getAllReferrals")
    public ResponseEntity<List<ReferralEntity>> getAllReferrals() {
        List<ReferralEntity> referrals = referralService.getAllReferrals();
        return new ResponseEntity<>(referrals, HttpStatus.OK);
    }

    @GetMapping("/getReferralById/{id}")
    public ResponseEntity<ReferralEntity> getReferralById(@PathVariable int id) {
        ReferralEntity referral = referralService.getReferralById(id);
        if (referral != null) {
            return new ResponseEntity<>(referral, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getReferralsByReferredById/{id}")
    public ResponseEntity<List<ReferralEntity>> getReferralsByReferredById(@PathVariable int id) {
        List<ReferralEntity> referrals = referralService.getReferralsByReferredById(id);
        return new ResponseEntity<>(referrals, HttpStatus.OK);
    }

    @PostMapping("/createReferral")
    public ResponseEntity<ReferralEntity> insertReferral(@RequestBody ReferralEntity referral) {
        ReferralEntity newReferral = referralService.saveReferral(referral);
        return new ResponseEntity<>(newReferral, HttpStatus.CREATED);
    }

    @PutMapping("/updateReferral/{id}")
    public ResponseEntity<ReferralEntity> updateReferral(@PathVariable int id, @RequestBody ReferralEntity referral) {
        ReferralEntity updatedReferral = referralService.updateReferral(id, referral);
        if (updatedReferral == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedReferral, HttpStatus.OK);
    }

    @DeleteMapping("/deleteReferral/{id}")
    public ResponseEntity<Void> deleteReferral(@PathVariable int id) {
        boolean deleted = referralService.deleteReferral(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
