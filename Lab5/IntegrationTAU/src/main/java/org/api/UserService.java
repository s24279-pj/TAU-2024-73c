package org.api;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User createUser(User user) {
        userRepository.addUser(user);
        return user;
    }

    public void updateUser(int id, User user) {
        userRepository.updateUser(id, user);
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }
}
