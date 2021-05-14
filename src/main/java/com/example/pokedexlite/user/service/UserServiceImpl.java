package com.example.pokedexlite.user.service;

import com.example.pokedexlite.user.entity.User;
import com.example.pokedexlite.user.exception.UserNotFoundException;
import com.example.pokedexlite.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findById(Long userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty())
            throw new UserNotFoundException("User not Found");
        return optionalUser.get();
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
