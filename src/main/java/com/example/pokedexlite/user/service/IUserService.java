package com.example.pokedexlite.user.service;

import com.example.pokedexlite.user.entity.User;
import com.example.pokedexlite.user.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {
     public User findById(Long userId) throws UserNotFoundException;
     public List<User> findAll();
}
