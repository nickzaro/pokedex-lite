package com.example.pokedexlite.ability.entity;


import com.example.pokedexlite.pokemon.entity.Pokemon;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "abilities")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "abilities")
    Set<Pokemon> pokemons;
}
