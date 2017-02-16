package com.assaabloy.notes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Note {

    private String noteId;
    private String userId;
    private String noteTitle;
    private String noteText;

    public Note() {

    }

    public Note(String noteId, String userId, String noteTitle, String noteText) {
        this.noteId = noteId;
        this.userId = userId;
        this.noteTitle = noteTitle;
        this.noteText = noteText;
    }

    @JsonProperty
    public String getUserId() {
        return userId;
    }

    @JsonProperty
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty
    public String getNoteId() {
        return noteId;
    }

    @JsonProperty
    public void setNoteId(String noteId) {
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
}
