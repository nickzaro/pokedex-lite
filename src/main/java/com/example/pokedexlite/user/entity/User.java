package com.example.pokedexlite.user.entity;


import com.example.pokedexlite.userpokemon.entity.UserPokemon;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER) // si el EAGER falla al cargar los datos, hacerlo Eager
    private Set<UserPokemon> userPokemons;

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

    public Set<UserPokemon> getUserPokemons() {
        return userPokemons;
    }

    public void setUserPokemons(Set<UserPokemon> userPokemons) {
        this.userPokemons = userPokemons;
    }

    @Override
    public String toString() {
        return "id: " + id + " | name: " + name;
    }
}
