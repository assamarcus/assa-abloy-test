package com.assaabloy.notes;

import com.assaabloy.notes.domain.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Ignore;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class NotesRepresentationTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void ANoteShouldSerializeToJSON() throws Exception {

        final Note note = new Note("1", "1", "todo", "wash");

        final String result = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/note.json"), Note.class));

        assertThat(MAPPER.writeValueAsString(note), is(result));
    }

    @Test
    @Ignore //TODO: fix!!
    public void ANoteShouldDeSerializeFromJSON() throws Exception {

        final Note note = new Note("1", "1", "todo", "wash");

        Note result = MAPPER.readValue(fixture("fixtures/note.json"), Note.class);

        assertThat(result, is(note));
    }
}
