package org.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static final String FILE_PATH = "src/main/resources/users.json";
    private List<User> users;

    public UserRepository() {
        try {
            loadUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public void updateUser(int id, User updatedUser) {
        Optional<User> userOptional = getUserById(id);
        userOptional.ifPresent(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
        });
        saveUsers();
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
        saveUsers();
    }

    private void loadUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        if (file.exists()) {
            users = objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } else {
            users = List.of();
        }
    }

    private void saveUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(FILE_PATH), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

