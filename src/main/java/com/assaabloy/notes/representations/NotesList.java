package com.assaabloy.notes.representations;

import io.dropwizard.jersey.params.LongParam;

import java.util.List;

public class NotesList {

    private List<Note> notes;
    private LongParam userId;

    public NotesList(LongParam userId, List<Note> notes) {
        this.notes = notes;
        this.userId = userId;
    }

    public LongParam getUserId() {
        return userId;
    }

    public void setUserId(LongParam userId) {
        this.userId = userId;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
