package com.example.pokedexlite.pokemon.ability.repository;

import com.example.pokedexlite.pokemon.ability.entity.Ability;
import org.springframework.data.repository.CrudRepository;

public interface IAbilityRepository extends CrudRepository<Ability,Long> {
}
