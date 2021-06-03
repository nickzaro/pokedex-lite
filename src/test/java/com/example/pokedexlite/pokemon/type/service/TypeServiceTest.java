package com.example.pokedexlite.pokemon.type.service;

import com.example.pokedexlite.pokemon.type.entity.Type;
import com.example.pokedexlite.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan
class TypeServiceTest {

    @Autowired
    ITypeService typeService;

    @Test
    @DisplayName("Listar todos los tipos")
    void findAll() {
        String[] usernames = {"Planta", "Veneno", "Fuego", "Volador","Agua","Bicho","Normal","Eléctrico","Tierra",
        "Hada","Lucha","Psíquico","Roca","Acero","Fantasma"};
        List<Type> types = typeService.findAll();
        int idx = 0;
        while (idx < types.size()) {
            assertEquals(types.get(idx).getName(), usernames[idx]);
            assertEquals(types.get(idx).getId(), (long) idx);
            idx++;
        }
    }
}