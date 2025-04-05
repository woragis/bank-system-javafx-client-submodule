package com.woragis.models;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final String email;
    private final String hashedPassword;

    public User(String name, String email, String hashedPassword) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
