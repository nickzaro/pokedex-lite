package com.example.pokedexlite.user.service;

import com.example.pokedexlite.user.entity.User;
import com.example.pokedexlite.user.exception.UserNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan
class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    @DisplayName("Excepción para Id inexistente")
    void userNotFoundExceptionfindById() throws UserNotFoundException {
        assertThrows(UserNotFoundException.class, () -> userService.findById(100L));
    }

    @Test
    @DisplayName("Excepción para id < 0")
    void userInvalidExceptionfindById() throws UserNotFoundException {
        assertThrows(UserNotFoundException.class, () -> userService.findById(-1L));
    }

    @Test
    @DisplayName("Recuperar al usuario id:1, Linus")
    void findById() throws UserNotFoundException {
        //1,'Linus'
        User user = userService.findById(1L);
        assertEquals(user.getId(), 1L);
        assertEquals(user.getName(), "Linus");
    }

    @Test
    @DisplayName("Listar todos los usuarios")
    void findAll() {
        String[] usernames = {"John", "Linus", "Jane", "Bruce"};
        List<User> users = userService.findAll();
        int idx = 0;
        while (idx < users.size()){
            assertEquals(users.get(idx).getName(), usernames[idx]);
            assertEquals(users.get(idx).getId(), (long) idx);
            idx++;
        }
    }
}