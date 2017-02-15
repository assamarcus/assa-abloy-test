package com.assaabloy.notes.domain;

import com.assaabloy.notes.Note;
import io.dropwizard.jersey.params.LongParam;

import java.util.List;

public class NotesList {

    private List<Note> notesList;
    private LongParam userId;

    public NotesList(LongParam userId, List<Note> notes) {
        this.notesList = notes;
        this.userId = userId;
    }

    public LongParam getUserId() {
        return userId;
    }

    public List<Note> getNotes() {
        return notesList;
    }
}
