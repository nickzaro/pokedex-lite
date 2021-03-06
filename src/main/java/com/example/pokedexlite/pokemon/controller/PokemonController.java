package com.example.pokedexlite.pokemon.controller;

import com.example.pokedexlite.pokemon.ability.entity.Ability;
import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.pokemon.exception.PokemonNotFoundException;
import com.example.pokedexlite.pokemon.service.IPokemonService;
import com.example.pokedexlite.pokemon.type.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
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
        pokemons.forEach(this::printPokemon);
        return true;
    }

    public void findByName(String name){
        Pokemon pokemon=null;
        try {
            pokemon = pokemonService.findByName(name);
        } catch (PokemonNotFoundException e){
            System.out.println("Not found pokemon: " + name);
            return;
        }
        printPokemon(pokemon);
    }

    public Pokemon saveNewPokemon(String nombre, int nivel, String descripcion) {
        return pokemonService.saveNewPokemon(nombre,(long)nivel,descripcion);
    }



    public void printEvolutionByName(String name) {
        List<Pokemon> pokemonList=null;
        try {
            pokemonList = pokemonService.evolutions(name);
        } catch (PokemonNotFoundException e) {
            System.out.println("Not found pokemon: " + name);
            return;
        }
        for (Pokemon pokemon: pokemonList) {
            printPokemon(pokemon);
        }
    }

    public void findByNameFull(String name){
        Pokemon pokemon=null;
        try {
            pokemon = pokemonService.findByName(name);
        } catch (PokemonNotFoundException e){
            System.out.println("Not found pokemon: " + name);
            return;
        }
        printPokemon(pokemon);
        System.out.println("---Habilidades del pokemon---" );
        printAbilitiesPokemon(pokemon);
        System.out.println("---Tipos del pokemon---");
        printTypesPokemon(pokemon);
    }

    private void printTypesPokemon(Pokemon pokemon) {
        for(Type type: pokemon.getTypes()){
            System.out.println(type);
        }
    }

    private void printAbilitiesPokemon(Pokemon pokemon) {
        for (Ability ability: pokemon.getAbilities()){
            System.out.println(ability);
        }
    }

    private void printPokemon(Pokemon pokemon){
        System.out.println("id: " + pokemon.getPokemonId() + " |name: " + pokemon.getName() + " |level: "+ pokemon.getLevel() + " | description: " + pokemon.getDescription());
    }
}
