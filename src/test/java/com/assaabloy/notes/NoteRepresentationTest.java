package com.assaabloy.notes;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Ignore;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NoteRepresentationTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void ANoteShouldSerializeToJSON() throws Exception {

        final Note note = new Note("1", "todo", "wash");

        final String result = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/note.json"), Note.class));

        assertThat(MAPPER.writeValueAsString(note)).isEqualTo(result);
    }

    @Test
    @Ignore
    public void ANoteShouldDeSerializeFromJSON() throws Exception {

        final Note note = new Note("1", "todo", "wash");

        assertThat(MAPPER.readValue(fixture("fixtures/note.json"), Note.class)).isEqualTo(note);
    }
}
