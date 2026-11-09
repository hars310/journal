package com.harshkumar.journal.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.harshkumar.journal.entity.JournalEntity;
import com.harshkumar.journal.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/get-all")
    public ResponseEntity<List<JournalEntity>> getAll() {
        List<JournalEntity> entityList = journalEntryService.findAll();
        return ResponseEntity.ok(entityList);
    }

    @PostMapping("/create")
    public ResponseEntity<JournalEntity> createEntry(@RequestBody JournalEntity myEntity) {
        try {
            myEntity.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(myEntity);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEntry(
            @PathVariable String id,
            @RequestBody JournalEntity newEntry) {

        Optional<JournalEntity> old = journalEntryService.findById(id);

        if (old.isPresent()) {
            JournalEntity existingEntry = old.get();

            existingEntry.setTitle(
                    newEntry.getTitle() != null && !newEntry.getTitle().isEmpty()
                            ? newEntry.getTitle()
                            : existingEntry.getTitle());

            existingEntry.setContent(
                    newEntry.getContent() != null && !newEntry.getContent().isEmpty()
                            ? newEntry.getContent()
                            : existingEntry.getContent());

            journalEntryService.saveEntry(existingEntry);

            return ResponseEntity.ok(existingEntry);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Journal entry not found");
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getJournalById(@PathVariable String id) {

        Optional<JournalEntity> journalEntry = journalEntryService.findById(id);

        if (journalEntry.isPresent()) {
            return ResponseEntity.ok(journalEntry.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Journal entry not found");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteJournalById(@PathVariable String id) {

        Optional<JournalEntity> journalEntry = journalEntryService.findById(id);

        if (journalEntry.isPresent()) {
            journalEntryService.deleteById(id);

            return ResponseEntity.ok("Journal entry deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Journal entry not found");
    }
}