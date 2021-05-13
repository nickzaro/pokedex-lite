package com.example.pokedexlite.user.repository;

import com.example.pokedexlite.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
}
