package com.example.pokedexlite;

import com.example.pokedexlite.pokemon.controller.PokemonController;
import com.example.pokedexlite.user.service.IUserService;
import com.example.pokedexlite.userpokemon.entity.UserPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    IUserService userService;

    @Autowired
    PokemonController pokemonController;

    @Autowired
    UserInterface userInterface;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("My application from command line");
        while (userInterface.listOptions()!=UserInterface.SALIR);
        System.out.println("My application is finished: ");

        /*
        pokemonController.listAllPokemon();
        pokemonController.findByName("juana");
        pokemonController.findByName("Bulbasaur");

         */

        System.exit(0);

    }
}
