package com.assaabloy.notes.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.jersey.params.LongParam;

public class Note {

    private LongParam noteId;
    private LongParam userId;
    private String noteTitle;
    private String noteText;

    public Note() {

    }

    public Note(LongParam noteId, LongParam userId, String noteTitle, String noteText) {
        this.noteId = noteId;
        this.userId = userId;
        this.noteTitle = noteTitle;
        this.noteText = noteText;
    }

    @JsonProperty
    public LongParam getUserId() {
        return userId;
    }

    @JsonProperty
    public void setUserId(LongParam userId) {
        this.userId = userId;
    }

    @JsonProperty
    public LongParam getNoteId() {
        return noteId;
    }

    @JsonProperty
    public void setNoteId(LongParam noteId) {
        this.noteId = noteId;
    }

    @JsonProperty
    public String getNoteTitle() {
        return noteTitle;
    }

    @JsonProperty
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    @JsonProperty
    public String getNoteText() {
        return noteText;
    }

    @JsonProperty
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (!noteId.equals(note.noteId)) return false;
        if (!userId.equals(note.userId)) return false;
        if (!noteTitle.equals(note.noteTitle)) return false;
        return noteText.equals(note.noteText);

    }

    @Override
    public int hashCode() {
        int result = noteId.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + noteTitle.hashCode();
        result = 31 * result + noteText.hashCode();
        return result;
    }
}
