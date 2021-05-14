package com.example.pokedexlite.pokemon.service;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.pokemon.repository.IPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Qualifier("pokemonservice")
public class PokemonServiceImpl implements IPokemonService{

    @Autowired
    IPokemonRepository pokemonRepository;



    @Override
    public List<Pokemon> findAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @Override
    public Pokemon findByName(String name) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findByName(name);
            if(pokemonOptional.isEmpty())
                throw new NullPointerException();
            return pokemonOptional.get();
        }

    @Override
    public List<Pokemon> evolutions(String name) {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemonBD = this.findByName(name); //TODO: Controlar la exception
        Pokemon poke = pokemonBD;
        while (poke != null){
            pokemons.add(poke);
        }
        return pokemons;
    }
}
