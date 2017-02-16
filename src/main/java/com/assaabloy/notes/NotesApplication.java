package com.assaabloy.notes;

import com.assaabloy.notes.repository.NotesRepository;
import com.assaabloy.notes.restapi.HealthCheckResource;
import com.assaabloy.notes.restapi.NotesResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NotesApplication extends Application<NotesConfiguration> {

    @Override
    public void initialize(Bootstrap<NotesConfiguration> bootstrap) {

    }

    public static void main(String[] args) throws Exception {
        new NotesApplication().run(args);
    }

    @Override
    public void run(NotesConfiguration configuration, Environment environment) {

        final NotesRepository notesRepository = new NotesRepository();
        final NotesResource resource = new NotesResource(notesRepository);

        environment.jersey().register(resource);

        environment.healthChecks().register("healthcheck", new HealthCheckResource());
    }
}
