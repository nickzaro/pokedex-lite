package com.example.pokedexlite.pokemon.service;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPokemonService {
    public List<Pokemon> findAll();
    public Pokemon findByName(String name);
    public List<Pokemon> evolutions(String name);
    public Pokemon save(Pokemon pokemon);
    public Pokemon saveNewPokemon(String name,Long level,String description);
}
