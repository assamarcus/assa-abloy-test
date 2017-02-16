package com.assaabloy.notes.restapi;

import com.assaabloy.notes.repository.UserRepository;
import com.assaabloy.notes.representations.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserResource {

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @POST
    public User addUser(@NotNull @Valid User user) {
        /* TODO: fixme!
        final long userId = userRepository.addUser(user);
        return Response.created(UriBuilder.fromResource(UserResource.class)
                .build(userId)).build();
                */
        return null;

    }
}
