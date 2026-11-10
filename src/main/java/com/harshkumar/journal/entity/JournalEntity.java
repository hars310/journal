package com.harshkumar.journal.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "journal_entries")
@Getter
@Setter
public class JournalEntity {

    @Id
    private String id;

    @NonNull 
    private String title;

    private String content;

    private LocalDateTime date;
}