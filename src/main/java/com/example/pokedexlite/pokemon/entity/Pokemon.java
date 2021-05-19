package com.example.pokedexlite.pokemon.entity;

import com.example.pokedexlite.ability.entity.Ability;
import com.example.pokedexlite.type.entity.Type;
import com.example.pokedexlite.userpokemon.entity.UserPokemon;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "pokemons")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokemon_id")
    private Long pokemonId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "level")
    private Long level;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "evolution_id", referencedColumnName = "pokemon_id")
    private Pokemon pokemonEvolution;

    @OneToOne(mappedBy = "pokemonEvolution")
    private Pokemon pokemonStarter;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    Set<Type> types;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pokemon_ability",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    Set<Ability> abilities;

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
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

    @Override
    public String toString() {
        return "id: " + pokemonId + "| name: " + name  + "| level: " + level + "| description=: " + description;
    }

    @Override
    public boolean equals(Object obj) {
        Pokemon other = (Pokemon)obj;
        return this.getName().equals(other.getName())
        && this.getLevel().equals(other.getLevel())
        && this.getPokemonId().equals(other.getPokemonId())
        && this.getDescription().equals(other.getDescription());
    }

    public boolean equalsAbilities(Set<Ability> abilities) {
        int sizeAbilities= abilities.size();
        if (sizeAbilities!= this.abilities.size())
            return false;
        int count = 0;
        for (Ability ability : this.abilities) {
            for (Ability ability1: abilities){
                if(ability1.equals(ability)) {
                    count++;
                    break; // todas las habilidades tienen nombres distintos
                }
            }
        }
        return count==sizeAbilities;
    }

    public boolean equalsTypes(Set<Type> types) {
        int sizeTypes= types.size();
        if (sizeTypes!= this.types.size())
            return false;
        int count = 0;
        for (Type type : this.types) {
            for (Type type1: types){
                if(type1.equals(type)) {
                    count++;
                    break; // todas las habilidades tienen nombres distintos
                }
            }
        }
        return count==sizeTypes;
    }
}