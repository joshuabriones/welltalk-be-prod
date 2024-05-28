package com.communicators.welltalk.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.communicators.welltalk.Service.JournalService;
import com.communicators.welltalk.Entity.JournalEntity;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/student/journal")
public class JournalController {

    @Autowired
    JournalService journalService;

    @GetMapping("/getAllJournals")
    public ResponseEntity<List<JournalEntity>> getAllJournals() {
        List<JournalEntity> journals = journalService.getAllJournals();
        return new ResponseEntity<>(journals, HttpStatus.OK);
    }

    @GetMapping("/getJournalById/{id}")
    public ResponseEntity<JournalEntity> getJournalById(@PathVariable int id) {
        JournalEntity journal = journalService.getJournalById(id);
        if (journal != null) {
            return new ResponseEntity<>(journal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getJournalByStudentId/{id}")
    public ResponseEntity<List<JournalEntity>> getJournalByStudentId(@PathVariable int id) {
        List<JournalEntity> journals = journalService.getJournalsByStudentId(id);
        return new ResponseEntity<>(journals, HttpStatus.OK);
    }

    @PostMapping("/createJournal")
    public ResponseEntity<JournalEntity> insertJournal(@RequestParam int userId, @RequestBody JournalEntity journal) {
        JournalEntity newJournal = journalService.saveJournal(userId, journal);
        return new ResponseEntity<>(newJournal, HttpStatus.CREATED);
    }

    @PutMapping("/updateJournal/{id}")
    public ResponseEntity<JournalEntity> updateJournal(@PathVariable int id, @RequestBody JournalEntity journal) {
        JournalEntity updatedJournal = journalService.updateJournal(id, journal);
        if (updatedJournal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedJournal, HttpStatus.OK);
    }

    @DeleteMapping("/deleteJournal/{id}")
    public ResponseEntity<Void> deleteJournal(@PathVariable int id) {
        boolean deleted = journalService.deleteJournal(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
