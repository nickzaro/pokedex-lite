package com.example.pokedexlite.pokemon.service;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.pokemon.exception.PokemonNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPokemonService {
    public List<Pokemon> findAll();
    public Pokemon findByName(String name) throws PokemonNotFoundException;
    public List<Pokemon> evolutions(String name) throws PokemonNotFoundException;
    public Pokemon save(Pokemon pokemon);
    public Pokemon saveNewPokemon(String name,Long level,String description);
}
