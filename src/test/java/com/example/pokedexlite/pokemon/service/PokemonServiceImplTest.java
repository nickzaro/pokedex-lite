package com.example.pokedexlite.pokemon.service;

import com.example.pokedexlite.ability.entity.Ability;
import com.example.pokedexlite.pokemon.entity.Pokemon;
import com.example.pokedexlite.type.entity.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan
class PokemonServiceImplTest {

    @Autowired
    //@Qualifier("pokemonservice")
    private IPokemonService pokemonService;
    Pokemon pokemon;
    Type type1;
    Type type2;
    Ability ability1;
    Pokemon evolution1;
    Pokemon evolution2;
    Pokemon butterfree;
    @BeforeEach
    void setUp() {
        type1 = new Type();
        type1.setName("Planta");
        type1.setDescription("Es del tipo planta");
        type2 = new Type();
        type2.setName("Veneno");
        type2.setDescription("Es del tipo Veneno");
        pokemon = new Pokemon();
        pokemon.setPokemonId(0L);
        pokemon.setName("Bulbasaur");
        pokemon.setLevel(1L);
        pokemon.setDescription("Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.");

        pokemon.setTypes(new HashSet<>());
        pokemon.getTypes().add(type1);
        pokemon.getTypes().add(type2);

         ability1= new Ability();
         ability1.setName("Espesura");
         ability1.setDescription("Potencia sus movimientos de tipo Planta cuando le quedan pocos PS.");
         pokemon.setAbilities(new HashSet<>());
         pokemon.getAbilities().add(ability1);

         /* Ivasaur */
        evolution1 = new Pokemon();
        evolution1.setPokemonId(1L);
        evolution1.setName("Ivasaur");
        evolution1.setLevel(10L);
        evolution1.setDescription("Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras.");
        evolution1.setTypes(new HashSet<>());
        evolution1.getTypes().add(type1);
        evolution1.getTypes().add(type2);
        evolution1.setAbilities(new HashSet<>());
        evolution1.getAbilities().add(ability1);

        /* Venusaur */
        evolution2 = new Pokemon();
        evolution2.setPokemonId(2L);
        evolution2.setName("Venusaur");
        evolution2.setLevel(100L);
        evolution2.setDescription("La planta florece cuando absorbe energía solar, lo cual le obliga a buscar siempre la luz del sol.");
        evolution2.setTypes(new HashSet<>());
        evolution2.getTypes().add(type1);
        evolution2.getTypes().add(type2);
        evolution2.setAbilities(new HashSet<>());
        evolution2.getAbilities().add(ability1);

        /* Butterfree*/
        butterfree = new Pokemon();
        butterfree.setName("Butterfree");
        butterfree.setLevel(25L);
        butterfree.setDescription("Aletea a gran velocidad para lanzar al aire sus escamas extremadamente tóxicas.");

    }


    @Test
    @DisplayName("Given a specific Pokemon’s name, its Name, Type/s and Level are retrieved from the Database")
    void findByName() {
        Pokemon pokemonBD = pokemonService.findByName("Bulbasaur");
        assertEquals(pokemonBD, pokemon);
        assertTrue(pokemonBD.equalsTypes(pokemon.getTypes()));
    }
    @Test
    @DisplayName("Given a specific Pokemon’s name, its Abilities and Evolutions are retrieved from the Database.")
    void findAbilitiesAndEvolutions(){
        Pokemon pokemonBD = pokemonService.findByName("Bulbasaur");
        assertTrue(pokemonBD.equalsAbilities(pokemon.getAbilities()));
        List<Pokemon> pokemonList = pokemonService.evolutions("Bulbasaur");
        assertEquals(pokemonList.get(0),pokemon);
        assertEquals(pokemonList.get(1),evolution1);
        assertEquals(pokemonList.get(2),evolution2);
    }

    @Test
    @DisplayName("A new Pokemon can be added (and later retrieved) to the Database.")
    void addNewRecovery(){
        Pokemon butterfreeBD = pokemonService.saveNewPokemon("Butterfree",25L,"Aletea a gran velocidad para lanzar al aire sus escamas extremadamente tóxicas.");
        butterfree.setPokemonId(butterfreeBD.getPokemonId()); // agrego la Id asignada por la bd al Pokemon falso.
        assertEquals(butterfreeBD,butterfree);
        Pokemon otherButterfreeBD = pokemonService.findByName("Butterfree"); // recuperando el pokemon agregado en la bd usando el nombre.
        assertEquals(otherButterfreeBD,butterfree);
    }
    @Test
    @DisplayName("A known Pokemon’s information (Name, Type/s or Level) can be updated in the Database.")
    void updateInformationPokemon(){
        String metapodName = "Metapod";
        Long metapodLevel = 1L;
        String metapodDescription ="Como en este estado solo puede endurecer su coraza, permanece inmóvil a la espera de evolucionar.";
        Long metapodId = 0L; // es el id de bulbasaur en la BD
        Pokemon bulbasaurBD = pokemonService.findByName("Bulbasaur"); //busco en la BD
        bulbasaurBD.setName(metapodName);
        bulbasaurBD.setLevel(metapodLevel);
        bulbasaurBD.setDescription(metapodDescription);
        pokemonService.save(bulbasaurBD); // Guardo los cambios en la BD
        Pokemon metapodBD = pokemonService.findByName("Metapod"); // Busco por el nuevo nombre
        assertEquals(metapodBD.getPokemonId(),metapodId);
        assertEquals(metapodBD.getName(),metapodName);
        assertEquals(metapodBD.getLevel(),metapodLevel);
        assertEquals(metapodBD.getDescription(),metapodDescription);

        //TODO: All Pokemons on the Database are listed
        // hacer un metodo de ordenado por id, para poder hacer assertEqual de cada pokemon
        //TODO:  Given a specific Pokemon’s name, all its Evolutions and their information (Name, Type/s and Level) are retrieved from the Database.
        // Lo mismo con los pokemon y sus evoluciones, para el caso particular, comparando el nombre level y los tipos.
    }
}