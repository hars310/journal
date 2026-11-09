package com.harshkumar.journal.entity;

public class JournalEntity {
    private long id;
    private String title;
    private String content;
    


    /// setters
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /// getters
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
