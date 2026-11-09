package com.harshkumar.journal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.harshkumar.journal.entity.JournalEntity;


public interface JournalEntryRepository extends MongoRepository<JournalEntity, String> {

}