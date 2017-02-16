package com.assaabloy.notes.repository;

import com.assaabloy.notes.representations.Note;
import com.assaabloy.notes.representations.NotesList;
import com.assaabloy.notes.representations.User;
import io.dropwizard.jersey.params.LongParam;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NotesRepositoryTest {

    @Test
    public void findAllNotesShouldReturnAllNotesInRepoForGivenUser() throws Exception {

        NotesRepository notesRepository = new NotesRepository();
        User user = createUser();
        Note note1 = createNote(user, "1", "todo", "wash");
        Note note2 = createNote(user, "2", "tomorrow", "interview!");
        int userId = user.getUserId().get().intValue();

        long result1 = notesRepository.addNote(userId, note1);
        long result2 = notesRepository.addNote(userId, note2);

        NotesList allNotesForUser = notesRepository.findAllNotesForUser(userId);

        assertThat(allNotesForUser.getNotes().size(), is(2));

        assertThat(allNotesForUser.getNotes().contains(note1), is(true));
        assertThat(allNotesForUser.getNotes().contains(note2), is(true));
    }

    @Test
    public void addedNoteShouldBeAvailableInRepo() throws Exception {

        NotesRepository notesRepository = new NotesRepository();
        User user = createUser();
        Note note = createNote(user, "1", "todo", "wash");
        long userId = user.getUserId().get().longValue();

        long result = notesRepository.addNote(userId, note);

        assertThat(result, is(userId));
    }

    private User createUser() {
        LongParam userId = new LongParam("1");
        return new User(userId, "Bosse");
    }

    private Note createNote(User user, String id, String title, String text) {
        LongParam noteId = new LongParam(id);
        return new Note(noteId, user.getUserId(), title, text);
    }
}