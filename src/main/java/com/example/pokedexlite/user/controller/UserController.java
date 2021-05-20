package com.example.pokedexlite.user.controller;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.pokemon.service.IPokemonService;
import com.example.pokedexlite.user.entity.User;
import com.example.pokedexlite.user.exception.UserNotFoundException;
import com.example.pokedexlite.user.service.IUserService;
import com.example.pokedexlite.userpokemon.entity.UserPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    @Autowired
    IUserService userService;

    public void printAllUser(){
        for (User user:userService.findAll()){
            System.out.println(user);
        }
    }

    public void printPokemonsUser(int userId){
        User user = null;
        try {
            user = userService.findById((long) userId);
        } catch (UserNotFoundException e) {
            System.out.println("El usuario ingresado no existe");
            return;
        }
        if(user.getUserPokemons().isEmpty()){
            System.out.println("El usuario no tiene pokemons");
            return;
        }

        for (UserPokemon userPokemon: user.getUserPokemons()){
            printUserPokemon(userPokemon);
        }
    }
    private void printUserPokemon(UserPokemon userPokemon){ //TODO: chequear que necesites UserPokemon y no pokemon
        System.out.println("id usuario: " + userPokemon.getUser().getId() + " |name: " + userPokemon.getPokemon().getName()
                + " |level: "+ userPokemon.getPokemon().getLevel() + " |description: " + userPokemon.getPokemon().getDescription()
                +" |alias: "+ userPokemon.getAlias() + " |current level: " + userPokemon.getCurrentLevel());
    }

}
