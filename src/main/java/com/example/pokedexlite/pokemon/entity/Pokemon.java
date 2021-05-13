package com.example.pokedexlite.pokemon.entity;

import com.example.pokedexlite.ability.entity.Ability;
import com.example.pokedexlite.type.entity.Type;
import com.example.pokedexlite.userpokemon.entity.UserPokemon;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "level")
    private Long level;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "id_evolution", referencedColumnName = "id")
    private Pokemon pokemonEvolution;

    @OneToOne(mappedBy = "pokemonEvolution")
    private Pokemon pokemonStarter;

    @OneToMany(mappedBy = "pokemon")
    Set<UserPokemon> userPokemons;

    @ManyToMany
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    Set<Type> types;

    @ManyToMany
    @JoinTable(
            name = "pokemon_ability",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    Set<Ability> abilities;

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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pokemon getPokemonEvolution() {
        return pokemonEvolution;
    }

    public void setPokemonEvolution(Pokemon pokemonEvolution) {
        this.pokemonEvolution = pokemonEvolution;
    }

    public Pokemon getPokemonStarter() {
        return pokemonStarter;
    }

    public void setPokemonStarter(Pokemon pokemonStarter) {
        this.pokemonStarter = pokemonStarter;
    }

    public Set<UserPokemon> getUserPokemons() {
        return userPokemons;
    }

    public void setUserPokemons(Set<UserPokemon> userPokemons) {
        this.userPokemons = userPokemons;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }
}
