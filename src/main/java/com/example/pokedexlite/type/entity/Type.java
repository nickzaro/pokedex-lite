package com.example.pokedexlite.type.entity;


import com.example.pokedexlite.pokemon.entity.Pokemon;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "types")
    Set<Pokemon> pokemons;
}
