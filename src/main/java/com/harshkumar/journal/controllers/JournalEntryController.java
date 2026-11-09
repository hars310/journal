package com.harshkumar.journal.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshkumar.journal.entity.JournalEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    
    private Map<Long, JournalEntity> journalEntities = new HashMap<>();


    @GetMapping("/get-all")
    public List<JournalEntity> getAll() {

        return new ArrayList<>(journalEntities.values());
    }
    
    @PostMapping("/create")
    public JournalEntity CreateEntry(@RequestBody JournalEntity myEntity) {
        Random random = new Random();
        long id = random.nextLong(100000);
        myEntity.setId(id);

        journalEntities.put(myEntity.getId(), myEntity);
        return myEntity;
    }

    @PutMapping("/update/{id}")
    public boolean updateEntry(@PathVariable long id,
            @RequestBody JournalEntity newEntry) {

        newEntry.setId(id);
        journalEntities.put(id, newEntry);

        return true;
    }
    
}
