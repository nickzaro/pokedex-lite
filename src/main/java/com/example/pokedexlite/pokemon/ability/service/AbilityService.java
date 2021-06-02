package com.example.pokedexlite.pokemon.ability.service;

import com.example.pokedexlite.pokemon.ability.entity.Ability;
import com.example.pokedexlite.pokemon.ability.repository.IAbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityService implements IAbilityService{

    @Autowired
    IAbilityRepository abilityRepository;

    @Override
    public List<Ability> findAll() {
        return (List<Ability>) abilityRepository.findAll();
    }
}
