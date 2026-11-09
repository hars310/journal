package com.harshkumar.journal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshkumar.journal.entity.JournalEntity;
import com.harshkumar.journal.repository.JournalEntryRepository;

@Service 
public class JournalEntryService {
   
    @Autowired 
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntity journalEntity)
    {
        journalEntryRepository.save(journalEntity);
    }

    public List<JournalEntity> findAll()
    {
        return journalEntryRepository.findAll();
    }
}


// controller --> service --> repository