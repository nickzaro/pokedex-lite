package com.example.pokedexlite.userpokemon.repository;

import com.example.pokedexlite.userpokemon.entity.UserPokemon;
import org.springframework.data.repository.CrudRepository;

public interface IUserPokemonRepository extends CrudRepository<UserPokemon,Long> {
}
