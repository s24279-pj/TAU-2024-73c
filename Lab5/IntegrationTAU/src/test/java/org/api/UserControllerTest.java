package org.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User(1, "Jan Kowalski", "jan.kowalski@example.com");
    }

    @Test
    public void testGetUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(testUser));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Jan Kowalski"))
                .andExpect(jsonPath("$[0].email").value("jan.kowalski@example.com"));
    }

    @Test
    public void testGetUserById_ExistingUser() throws Exception {
        when(userService.getUserById(1)).thenReturn(Optional.of(testUser));

        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jan Kowalski"))
                .andExpect(jsonPath("$.email").value("jan.kowalski@example.com"));
    }

    @Test
    public void testGetUserById_NonExistingUser() throws Exception {
        when(userService.getUserById(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/users/{id}", 999))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateUser_Success() throws Exception {
        when(userService.createUser(any(User.class))).thenReturn(testUser);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Jan Kowalski\", \"email\": \"jan.kowalski@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Jan Kowalski"))
                .andExpect(jsonPath("$.email").value("jan.kowalski@example.com"));
    }

    @Test
    public void testCreateUser_BadRequest() throws Exception {
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"\", \"email\": \"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateUser_Success() throws Exception {
        User updatedUser = new User(1, "Jan Nowak", "jan.nowak@example.com");

        // Jeśli metoda nie zwraca żadnej wartości, używamy doNothing()
        when(userService.getUserById(1)).thenReturn(Optional.of(testUser));
        doNothing().when(userService).updateUser(1, updatedUser);

        mockMvc.perform(put("/users/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Jan Nowak\", \"email\": \"jan.nowak@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jan Nowak"))
                .andExpect(jsonPath("$.email").value("jan.nowak@example.com"));
    }


    @Test
    public void testUpdateUser_NotFound() throws Exception {
        User updatedUser = new User(999, "Jan Nowak", "jan.nowak@example.com");
        when(userService.getUserById(999)).thenReturn(Optional.empty());

        mockMvc.perform(put("/users/{id}", 999)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Jan Nowak\", \"email\": \"jan.nowak@example.com\"}"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteUser_Success() throws Exception {
        when(userService.getUserById(1)).thenReturn(Optional.of(testUser));
        doNothing().when(userService).deleteUser(1);

        mockMvc.perform(delete("/users/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteUser_NotFound() throws Exception {
        when(userService.getUserById(999)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/users/{id}", 999))
                .andExpect(status().isNotFound());
    }
}
