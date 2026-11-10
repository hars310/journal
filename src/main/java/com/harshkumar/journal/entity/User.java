package com.harshkumar.journal.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data 
@Document("users")
public class User {
    
    @Id private ObjectId id;
    
    // this annotation makes the username unique
    @Indexed(unique = true)
    @NonNull 
    private String username;

    @NonNull 
    private String password;


    @DBRef()
    List<JournalEntity> journal_entries = new ArrayList<>();

    private LocalDateTime date;
}
