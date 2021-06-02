package com.example.pokedexlite.pokemon.type.service;

import com.example.pokedexlite.pokemon.type.entity.Type;
import com.example.pokedexlite.pokemon.type.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService{

    @Autowired
    ITypeRepository typeRepository;

    @Override
    public List<Type> findAll() {
        return (List<Type>) typeRepository.findAll();
    }
}
