package com.example.pokedexlite.pokemon.controller;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.pokemon.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PokemonController {

    @Autowired
    IPokemonService pokemonService;

    public boolean printAllPokemon(){
        List<Pokemon> pokemons=pokemonService.findAll();
        if(pokemons.isEmpty()){
            System.out.println("Data base is Empty");
            return false;
        }
        pokemons.forEach(System.out::println);
        return true;
    }

    public void findByName(String name){
        Pokemon pokemon=null;
        try {
            pokemon = pokemonService.findByName(name);
        } catch (NullPointerException ex){
            System.out.println("Not found pokemon: " + name);
            return;
        }
        System.out.println(pokemon);
    }

    public Pokemon saveNewPokemon(String nombre, int nivel, String descripcion) {
        return pokemonService.saveNewPokemon(nombre,(long)nivel,descripcion);
    }
}
