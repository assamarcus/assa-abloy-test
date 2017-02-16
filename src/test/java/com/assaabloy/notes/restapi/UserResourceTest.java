package com.assaabloy.notes.restapi;

import com.assaabloy.notes.repository.UserRepository;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class UserResourceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserResource resource = new UserResource(userRepository);

    @Test
    public void addUser() {

        //TODO: implement

    }
}