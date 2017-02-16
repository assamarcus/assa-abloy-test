package com.assaabloy.notes.repository;

import com.assaabloy.notes.representations.User;
import io.dropwizard.jersey.params.LongParam;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserRepository {
    Set<User> users = new HashSet();
    SimpleLongIdGenerator idGen = new SimpleLongIdGenerator();

    public long addUser(User user) {
        long userId = idGen.next();
        User newUser = new User(new LongParam(Long.toString(userId)), user.getUserName());
        users.add(newUser);
        return userId;
    }


}
