package com.harshkumar.journal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshkumar.journal.entity.JournalEntity;
import com.harshkumar.journal.repository.JournalEntryRepository;

@Service
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public void saveEntry(JournalEntity journalEntity) {
        journalEntryRepository.save(journalEntity);
    }

    public List<JournalEntity> findAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntity> findById(String id) {
        return journalEntryRepository.findById(id);
    }

    public void deleteById(String id) {
        journalEntryRepository.deleteById(id);
    }
}
