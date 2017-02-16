package com.assaabloy.notes;

import com.assaabloy.notes.domain.Note;
import com.assaabloy.notes.domain.NotesList;
import com.assaabloy.notes.repository.NotesRepository;
import com.assaabloy.notes.restapi.NotesResource;
import io.dropwizard.jersey.params.IntParam;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NotesResourceTest {

    private final NotesRepository notesRepository = mock(NotesRepository.class);
    private final NotesResource resource = new NotesResource(notesRepository);

    @Test
    public void findAllForUserShouldReturnSameUserId() {
        final List<Note> notes = mock(List.class);
        when(notesRepository.findAllNotesForUser(1)).thenReturn(notes);

        final NotesList list = resource.findAllNotesForUser(new IntParam("1"));

        assertThat(list.getUserId(), is(new IntParam("1")));
    }

    @Test
    public void findAllForUserShouldReturnListOfNotes() {
        final List<Note> notes = mock(List.class);
        when(notesRepository.findAllNotesForUser(1)).thenReturn(notes);

        final NotesList list = resource.findAllNotesForUser(new IntParam("1"));

        assertThat(list.getNotes(), is(notes));
    }
}
