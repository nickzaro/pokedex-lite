package com.example.pokedexlite.pokemon.ability.entity;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public boolean equals(Object obj) {
        Ability ability = (Ability)obj;
        return this.getName().equals(ability.getName())
                && this.getDescription().equals(ability.getDescription());
    }

    @Override
    public String toString() {
        return "name: " + name + " | description: " + description;
    }
}
