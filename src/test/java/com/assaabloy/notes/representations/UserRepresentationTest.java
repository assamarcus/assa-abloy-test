package com.assaabloy.notes.representations;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jersey.params.LongParam;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserRepresentationTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper()
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    private final User user = new User(new LongParam("1"), "Bosse");

    @Test
    public void AUserShouldSerializeToJSON() throws Exception {

        final String result = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/user.json"), User.class));

        assertThat(MAPPER.writeValueAsString(user), is(result));
    }

    @Test
    public void AUserShouldDeSerializeFromJSON() throws Exception {

        assertThat(MAPPER.readValue(fixture("fixtures/user.json"), User.class),
                equalTo(user));
    }
}
