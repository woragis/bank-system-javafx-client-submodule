package com.woragis.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.woragis.models.User;

public class UserRepository {
    private final Map<String, User> usersByEmail = new HashMap<>();

    public void save(User user) {
        usersByEmail.put(user.getEmail(), user);
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(usersByEmail.get(email));
    }

    public boolean existsByEmail(String email) {
        return usersByEmail.containsKey(email);
    }
}
