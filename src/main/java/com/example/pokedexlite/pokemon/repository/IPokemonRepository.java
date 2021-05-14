package com.example.pokedexlite.pokemon.repository;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IPokemonRepository extends CrudRepository<Pokemon,Long> {

    Optional<Pokemon> findByName(String name);


}
