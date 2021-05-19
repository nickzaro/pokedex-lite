package com.example.pokedexlite.userpokemon.entity;

import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.user.entity.User;

import javax.persistence.*;

@Entity(name = "user_pokemon")
@PrimaryKeyJoinColumn(name = "user_pokemon_id")
public class UserPokemon extends Pokemon{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "alias")
    private String alias;

    @Column(name = "current_level")
    private Long currentLevel;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Long currentLevel) {
        this.currentLevel = currentLevel;
    }
}
