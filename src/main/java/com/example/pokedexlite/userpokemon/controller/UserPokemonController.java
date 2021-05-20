package com.example.pokedexlite.userpokemon.controller;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.pokemon.exception.PokemonNotFoundException;
import com.example.pokedexlite.pokemon.service.IPokemonService;
import com.example.pokedexlite.user.entity.User;
import com.example.pokedexlite.user.exception.UserNotFoundException;
import com.example.pokedexlite.user.service.IUserService;
import com.example.pokedexlite.userpokemon.entity.UserPokemon;
import com.example.pokedexlite.userpokemon.service.IUserPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UserPokemonController {
    @Autowired
    IUserService userService;

    @Autowired
    IPokemonService pokemonService;

    @Autowired
    IUserPokemonService userPokemonService;

    public void save(int user_id, int pokemon_id, String alias) {
        UserPokemon userPokemon = new UserPokemon();
        User user = null;
        Pokemon pokemon= null;
        try {
            user = userService.findById((long) user_id);
            pokemon = pokemonService.findById((long)pokemon_id);
        } catch (UserNotFoundException | PokemonNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        userPokemon.setUser(user);
        userPokemon.setPokemon(pokemon);
        userPokemon.setAlias(alias);
        // numero al azar para el pokemon, como base el nivel de evolución de pokemon genérico.
        userPokemon.setCurrentLevel((long) (Math.random()*(100-pokemon.getLevel())+pokemon.getLevel()));
        userPokemonService.save(userPokemon);
    }
}
