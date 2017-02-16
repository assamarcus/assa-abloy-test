package com.assaabloy.notes.repository;

import com.assaabloy.notes.representations.Note;
import com.assaabloy.notes.representations.NotesList;
import io.dropwizard.jersey.params.LongParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesRepository {

    Map<Long, List<Note>> repo = new HashMap<>();

    public long addNote(long userId, Note note) {
        List<Note> notes = repo.get(userId);
        if (notes == null) {
            notes = new ArrayList<>();
        }
        notes.add(note);
        repo.put(userId, notes);
        return userId;
    }

    public NotesList findAllNotesForUser(long userId) {
        List<Note> notes = repo.get(userId);
        return new NotesList(new LongParam(String.valueOf(userId)), notes);
    }

    //TODO: return boolean..? Do not like -1
    /*public int addNote(int userId, Note note) {
        NotesList notesList = findAllNotesForUser(userId);
        if (notesList.getNotes() == null) {
            notesList.setNotes(new ArrayList<>());
        }

        if (notesList.getNotes().add(note)) {
            return userId;
        }
        else {
            return -1;
        }
    }*/


    public Note getNote(long userId, long noteId) {
        NotesList notesList = findAllNotesForUser(userId);

        for(Note note : notesList.getNotes()) {
            if (note.getNoteId().get().intValue() == noteId) {
                return note;
            }
        }
        return null;
    }
}
