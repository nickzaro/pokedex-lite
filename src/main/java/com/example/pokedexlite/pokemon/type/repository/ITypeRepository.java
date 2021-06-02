package com.example.pokedexlite.pokemon.type.repository;

import com.example.pokedexlite.pokemon.type.entity.Type;
import org.springframework.data.repository.CrudRepository;

public interface ITypeRepository extends CrudRepository<Type,Long> {
}
