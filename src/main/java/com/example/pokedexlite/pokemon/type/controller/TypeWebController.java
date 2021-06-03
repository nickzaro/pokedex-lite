package com.example.pokedexlite.pokemon.type.controller;

import com.example.pokedexlite.pokemon.ability.entity.Ability;
import com.example.pokedexlite.pokemon.ability.service.IAbilityService;
import com.example.pokedexlite.pokemon.type.entity.Type;
import com.example.pokedexlite.pokemon.type.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeWebController {

    @Autowired
    ITypeService typeService;

    @GetMapping("/")
    public String findAll(Model model){
        List<Type> types = typeService.findAll();
        model.addAttribute("title","Lista de Tipos");
        model.addAttribute("types", types);
        return "pokemon/type/findAll";
    }
}
