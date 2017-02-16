package com.assaabloy.notes.restapi;

import com.assaabloy.notes.repository.NotesRepository;
import com.assaabloy.notes.representations.NotesList;
import io.dropwizard.jersey.params.LongParam;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NotesResourceTest {

    private final NotesRepository notesRepository = mock(NotesRepository.class);
    private final NotesResource resource = new NotesResource(notesRepository);

    /*
    public NotesList findAllNotesForUser(int userId) {
        List<Note> notes = repo.get(Integer.valueOf(userId));
        return new NotesList(new LongParam(String.valueOf(userId)), notes);
    }*/
    @Test
    public void findAllForUserShouldReturnSameUserId() {
        final NotesList notes = mock(NotesList.class);
        when(notesRepository.findAllNotesForUser(1)).thenReturn(notes);

        final NotesList list = resource.findAllNotesForUser(new LongParam("1"));

        assertThat(list.getUserId(), is(new LongParam("1")));
    }

    @Test
    @Ignore //TODO: for now..
    public void findAllForUserShouldReturnListOfNotes() {
        final NotesList notesList = mock(NotesList.class);
        when(notesRepository.findAllNotesForUser(1)).thenReturn(notesList);

        final NotesList list = resource.findAllNotesForUser(new LongParam("1"));

        assertThat(list, is(notesList));
    }
}
