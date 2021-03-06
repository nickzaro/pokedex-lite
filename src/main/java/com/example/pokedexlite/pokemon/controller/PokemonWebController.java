package com.example.pokedexlite.pokemon.controller;

import com.example.pokedexlite.pokemon.ability.entity.Ability;
import com.example.pokedexlite.pokemon.ability.repository.IAbilityRepository;
import com.example.pokedexlite.pokemon.ability.service.IAbilityService;
import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.pokemon.exception.PokemonNotFoundException;
import com.example.pokedexlite.pokemon.repository.IPokemonRepository;
import com.example.pokedexlite.pokemon.service.IPokemonService;
import com.example.pokedexlite.pokemon.type.entity.Type;
import com.example.pokedexlite.pokemon.type.repository.ITypeRepository;
import com.example.pokedexlite.pokemon.type.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("pokemon/")
public class PokemonWebController {

    @Autowired
    IPokemonService pokemonService;

    @Autowired
    IAbilityService abilityService;

    @Autowired
    ITypeService typeService;


    @GetMapping("/add")
    public String addPokemon(Model model){
        // TODO: pasar solo pokemones que no tengan asignado un pokemon base.
        Pokemon pokemon = new Pokemon();
        List<Ability> abilities = abilityService.findAll();
        List<Type> types = typeService.findAll();
        List<Pokemon> pokemons = pokemonService.findAll();
        model.addAttribute("title","Nuevo pokemon");
        model.addAttribute("allAbilities", abilities);
        model.addAttribute("allTypes",types);
        model.addAttribute("allPokemons",pokemons);
        model.addAttribute("pokemon",pokemon);
        return "pokemon/addPokemon";
    }

    @PostMapping("/add")
    public String saveNewPokemon(Pokemon pokemon){
        pokemonService.save(pokemon);
        return "pokemon/addPokemon";
    }

    @GetMapping({"/",""})
    public String findAll(Model model){
        List<Pokemon> pokemones = pokemonService.findAll();
        model.addAttribute("title","Lista de pokemones");
        model.addAttribute("pokemones", pokemones);
        return "pokemon/findAll";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable(value = "id") Long id, Model model) {
        Pokemon pokemon = null;
        try {
            pokemon = pokemonService.findById(id);
        } catch (PokemonNotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "Datos del pokemon");
        model.addAttribute("pokemon", pokemon);
        return "pokemon/findById";
    }

}
