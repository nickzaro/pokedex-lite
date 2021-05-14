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
    @Override
    public void run(String... args) throws Exception {

        System.out.println("My application from command line");
        Scanner read = new Scanner(System.in);
        Long num = read.nextLong();
        System.out.println("My application is finished: " + num);

        pokemonController.listAllPokemon();
        pokemonController.findByName("juana");
        pokemonController.findByName("Bulbasaur");


        System.exit(0);

    }
}
