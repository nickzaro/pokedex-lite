package com.example.pokedexlite.userpokemon.service;

import com.example.pokedexlite.userpokemon.entity.UserPokemon;
import com.example.pokedexlite.userpokemon.repository.IUserPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPokemonServiceImpl implements IUserPokemonService{

    @Autowired
    IUserPokemonRepository userPokemonRepository;

    @Override
    public void save(UserPokemon userPokemon) {
        userPokemonRepository.save(userPokemon);
    }
}
