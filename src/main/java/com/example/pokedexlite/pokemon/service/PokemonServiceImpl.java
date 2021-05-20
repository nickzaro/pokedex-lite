package com.example.pokedexlite.pokemon.service;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.pokemon.exception.PokemonNotFoundException;
import com.example.pokedexlite.pokemon.repository.IPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Qualifier("pokemonservice")
public class PokemonServiceImpl implements IPokemonService {

    @Autowired
    IPokemonRepository pokemonRepository;


    @Override
    public List<Pokemon> findAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @Override
    public Pokemon findById(Long id) throws PokemonNotFoundException {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
        if (pokemonOptional.isEmpty())
            throw new PokemonNotFoundException("Pokemon not Found");
        return pokemonOptional.get();
    }

    @Override
    public Pokemon findByName(String name) throws PokemonNotFoundException {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findByNameIgnoreCase(name);
        if (pokemonOptional.isEmpty())
            throw new PokemonNotFoundException("Pokemon not Found");
        return pokemonOptional.get();
    }

    @Override
    public List<Pokemon> evolutions(String name) throws PokemonNotFoundException {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemonBD = this.findByName(name);
        if (pokemonBD == null)
            throw new PokemonNotFoundException("Pokemon not Found");
        Pokemon poke = pokemonBD;
        while (poke != null) {
            pokemons.add(poke);
            poke = poke.getPokemonEvolution();
        }
        return pokemons;
    }

    @Override
    public Pokemon save(Pokemon pokemon) {
        pokemon = pokemonRepository.save(pokemon);
        return pokemon;
    }

    @Override
    public Pokemon saveNewPokemon(String name, Long level, String description) {
        Pokemon newPokemon = new Pokemon();
        newPokemon.setName(name);
        newPokemon.setLevel(level);
        newPokemon.setDescription(description);
        newPokemon = save(newPokemon);
        return newPokemon;
    }
}
