package com.example.pokedexlite.pokemon.service;

import com.example.pokedexlite.ability.entity.Ability;
import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.type.entity.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan
class PokemonServiceImplTest {

    @Autowired
    //@Qualifier("pokemonservice")
    private IPokemonService pokemonService;
    Pokemon pokemon;
    Type type1;
    Type type2;
    Ability ability1;

    @BeforeEach
    void setUp() {
        type1 = new Type();
        type1.setName("Planta");
        type1.setDescription("Es del tipo planta");
        type2 = new Type();
        type2.setName("Veneno");
        type2.setDescription("Es del tipo Veneno");
        pokemon = new Pokemon();
        pokemon.setPokemonId(0L);
        pokemon.setName("Bulbasaur");
        pokemon.setLevel(1L);
        pokemon.setDescription("Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.");
        pokemon.setTypes(new HashSet<>());
        pokemon.getTypes().add(type1);
        pokemon.getTypes().add(type2);
         ability1= new Ability();
         ability1.setName("Espesura");
         ability1.setDescription("Potencia sus movimientos de tipo Planta cuando le quedan pocos PS.");
         pokemon.setAbilities(new HashSet<>());
         pokemon.getAbilities().add(ability1);


    }

    /*
    @Test
    void findAll() {
    }
     */


    @Test
    @DisplayName("Given a specific Pokemon’s name, its Name, Type/s and Level are retrieved from the Database")
    void findByName() {
        Pokemon pokemonBD = pokemonService.findByName("Bulbasaur");
        assertEquals(pokemonBD, pokemon);
        assertTrue(pokemonBD.equalsTypes(pokemon.getTypes()));
    }

}