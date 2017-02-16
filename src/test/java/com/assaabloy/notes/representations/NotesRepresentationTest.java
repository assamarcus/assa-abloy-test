package com.assaabloy.notes.representations;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jersey.params.LongParam;
import org.junit.Ignore;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NotesRepresentationTest {

    /*
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private final Note testNote = new Note(new LongParam("1"), new LongParam("1"), "todo", "wash");

    @Test
    public void ANoteShouldSerializeToJSON() throws Exception {

        final String result = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/note.json"), Note.class));

        assertThat(MAPPER.writeValueAsString(testNote), is(result));
    }

    @Test
    @Ignore //TODO: fix!!
    public void ANoteShouldDeSerializeFromJSON() throws Exception {

        Note result = MAPPER.readValue(fixture("fixtures/note.json"), Note.class);

        assertThat(result, is(testNote));
    }*/
}
