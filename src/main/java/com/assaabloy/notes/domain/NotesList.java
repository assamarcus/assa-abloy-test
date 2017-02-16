package com.assaabloy.notes.domain;

import io.dropwizard.jersey.params.IntParam;

import java.util.List;

public class NotesList {


    private List<Note> notesList;
    private IntParam userId;

    public NotesList(IntParam userId, List<Note> notes) {
        this.notesList = notes;
        this.userId = userId;
    }

    public IntParam getUserId() {
        return userId;
    }

    public List<Note> getNotes() {
        return notesList;
    }
}
