package com.assaabloy.notes.restapi;

import com.assaabloy.notes.repository.NotesRepository;
import com.assaabloy.notes.repository.UserRepository;
import com.assaabloy.notes.representations.NotesList;
import com.assaabloy.notes.representations.User;
import io.dropwizard.jersey.params.LongParam;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserResourceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserResource resource = new UserResource(userRepository);

    @Test
    public void addUser() {

        //TODO: implement

    }
}