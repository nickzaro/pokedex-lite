package com.example.pokedexlite;

import com.example.pokedexlite.pokemon.entity.Pokemon;
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

    @Override
    public void run(String... args) throws Exception {

        System.out.println("My application from command line");
        Scanner read = new Scanner(System.in);
        Long num = read.nextLong();
        for(UserPokemon userPokemon:userService.findById(num).getUserPokemons()){
            System.out.println("pokemon name: "+ userPokemon.getName()+ " pokemon level: " + userPokemon.getLevel() + " ");
        }
        System.out.println("My application is finished: " + num);
        System.exit(0);

    }
}
