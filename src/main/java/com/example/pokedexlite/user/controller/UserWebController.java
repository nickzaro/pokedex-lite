package com.example.pokedexlite.user.controller;

import com.example.pokedexlite.user.entity.User;
import com.example.pokedexlite.user.exception.UserNotFoundException;
import com.example.pokedexlite.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping({"/user"})
public class UserWebController {
    @Autowired
    IUserService userService;


    @GetMapping({"/",""})
    public String printAllUsers(Model model){
        model.addAttribute("title","Todos los usuarios");
        model.addAttribute("users",userService.findAll());
        return "user/printAllUsers";
    }

    /*

    @GetMapping("/{id}")
    public String findById(@PathVariable(value = "id") Long id, Model model) {
        User user = null;
        try {
            user = userService.findById(id);
        } catch ( UserNotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "user pokemons");
        model.addAttribute("user", user);
        return "user/findById";
    }


     */

    @GetMapping("/{id}/pokemons/")
    public String listPokemonsForUser(@PathVariable(value = "id") Long id, Model model) {
        User user = null;
        try {
            user = userService.findById(id);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "user pokemons");
        model.addAttribute("user", user);
        return "user/listPokemonsForUser";
    }
}
