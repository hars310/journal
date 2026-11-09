package com.harshkumar.journal.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal_entries")
public class JournalEntity {

    @Id 
    private String id;
    
    private String title;
    
    private String content;
    
    private LocalDateTime date;

    /// setters
    public void setId(String id) {
        this.id = id;
    }
    

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /// getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
