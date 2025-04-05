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

    public boolean resetPassword(String email, String name, String newPassword) {
        var userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty())
            return false;

        User user = userOpt.get();
        if (!user.getName().equals(name))
            return false; // Basic identity check

        String hashed = PasswordUtils.hashPassword(newPassword);
        User updatedUser = new User(user.getName(), user.getEmail(), hashed); // recreate user
        userRepository.save(updatedUser);
        return true;
    }

}
