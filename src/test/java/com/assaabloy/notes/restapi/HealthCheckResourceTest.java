package com.assaabloy.notes.restapi;

import io.dropwizard.testing.junit.DropwizardClientRule;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HealthCheckResourceTest {

    //REFACTOR ME!! baseuri for admin, strings etc.
    //replace with curl, since mvn needs a running app. This is acc testing
    //curl http://localhost:8081/healthcheck


    static {
        System.setProperty("deployment_architecture", "hsql");
        System.setProperty("opodo.log4j.dir", "logs");
    }

    @ClassRule
    public static final DropwizardClientRule dropwizardClientRule =
            new DropwizardClientRule(new HealthCheckResource());

    @Test
    @Ignore
    public void shouldRespondAliveWhenGivenCorrectUrl() throws IOException {
        String healthCheckUrl = "http://localhost:8081/healthcheck";
        URL url = new URL(healthCheckUrl);
        String response = new BufferedReader(new InputStreamReader(url.openStream())).readLine();
        assertThat("{\"deadlocks\":{\"healthy\":true},\"healthcheck\":{\"healthy\":true}}", is(response));
    }

    @Ignore
    @Test(expected = FileNotFoundException.class)
    public void shouldThrowExceptionWhenGivenWrongUrl() throws IOException {
        URL url = new URL(dropwizardClientRule.baseUri() + "/application/halsokontroll");
        new InputStreamReader(url.openStream());
    }
}
