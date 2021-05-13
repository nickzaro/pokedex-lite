package com.example.pokedexlite.user.service;

import com.example.pokedexlite.user.entity.User;
import com.example.pokedexlite.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserServiceImp implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty())
            return null; // regreso null si no existe el usuario;
        return optionalUser.get();
    }
}
