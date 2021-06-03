package com.example.pokedexlite.pokemon.ability.controller;

import com.example.pokedexlite.pokemon.ability.entity.Ability;
import com.example.pokedexlite.pokemon.ability.service.IAbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ability")
public class AbilityWebController {

    @Autowired
    IAbilityService abilityService;

    @GetMapping("/")
    public String findAll(Model model){
        List<Ability> abilities = abilityService.findAll();
        model.addAttribute("title","Lista de habilidades");
        model.addAttribute("abilities", abilities);
        return "pokemon/ability/findAll";
    }
}
