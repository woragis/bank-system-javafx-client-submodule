package com.woragis.services;

import com.woragis.models.User;
import com.woragis.repositories.UserRepository;
import com.woragis.utils.PasswordUtils;

public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            return false;
        }
        String hashed = PasswordUtils.hashPassword(password);
        User user = new User(name, email, hashed);
        userRepository.save(user);
        return true;
    }

    public boolean login(String email, String password) {
        var userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty())
            return false;

        String hashed = PasswordUtils.hashPassword(password);
        return userOpt.get().getHashedPassword().equals(hashed);
    }
}
