package com.harshkumar.journal.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshkumar.journal.entity.JournalEntity;
import com.harshkumar.journal.service.JournalEntryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    JournalEntryService journalEntryService;

    private Map<Long, JournalEntity> journalEntities = new HashMap<>();

    @GetMapping("/get-all")
    public List<JournalEntity> getAll() {
        List<JournalEntity> entitylist = journalEntryService.findAll();
        return entitylist;
    }

    @PostMapping("/create")
    public JournalEntity CreateEntry(@RequestBody JournalEntity myEntity) {
        myEntity.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntity);
        return myEntity;
    }

    @PutMapping("/update/{id}")
    public boolean updateEntry(@PathVariable long id,
            @RequestBody JournalEntity newEntry) {

        return true;
    }

}
