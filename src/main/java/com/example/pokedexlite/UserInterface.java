package com.example.pokedexlite;

import com.example.pokedexlite.pokemon.controller.PokemonController;
import com.example.pokedexlite.user.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInterface {

    static final int SALIR = 0, LISTAR_OPCIONES = 1, LISTAR_USUARIOS = 2, LISTAR_POKEMONS = 3,
            LISTAR_POKEMONS_POR_USUARIO = 4, BUSCAR_POKEMON = 5,AGREGAR_POKEMON = 6, EVOLUCIONES = 7;

    @Autowired
    PokemonController pokemonController;
    @Autowired
    UserController userController;

    Scanner read = new Scanner(System.in);

    int listOptions() {
        System.out.println("---------------------------------------------------");
        System.out.println("------------------Lista de Opciones----------------");
        System.out.println(LISTAR_OPCIONES + " .-Listar todas las opciones");
        System.out.println(LISTAR_USUARIOS + " .-Listar todos los usuarios");
        System.out.println(LISTAR_POKEMONS + " .-Listar todas los pokemons");
        System.out.println(LISTAR_POKEMONS_POR_USUARIO + " .-Pokemons por usuario");
        System.out.println(BUSCAR_POKEMON + " .-Buscar pokemon por el nombre");
        System.out.println(AGREGAR_POKEMON + " .-Agregar nuevo pokemon");
        System.out.println(EVOLUCIONES + " .-Evoluciones de un pokemon");
        System.out.println(SALIR + " .-Terminar el programa");
        System.out.print("Ingrese una opción: ");
        return evaluateOption(inputOption());
    }

    int inputOption() {
        Scanner read = new Scanner(System.in);
        int numero = read.nextInt();
        return numero;
    }

    int evaluateOption(int numero) {
        switch (numero) {
            case LISTAR_OPCIONES:
                listOptions();
                break;

            case LISTAR_POKEMONS:
                listPokemons();
                break;

            case LISTAR_POKEMONS_POR_USUARIO:
                listPokemonsUser();
                break;

            case LISTAR_USUARIOS:
                userList();
                break;

            case AGREGAR_POKEMON:
                newPokemon();
                break;

            case EVOLUCIONES:
                evolutionPokemon();
                break;

            case SALIR:
                salir();
                break;

            case BUSCAR_POKEMON:
                buscarPokemon();
                break;
            default:
                opcionFueraDeRango();
        }
        return numero;
    }

    private void newPokemon() {
        System.out.println("------------------Nuevo pokemon----------------");
        System.out.print("Ingrese el Nombre: ");
        String nombre = read.nextLine();
        System.out.print("Ingrese el Nivel: ");
        int nivel = read.nextInt();
        read.nextLine(); // para consumir el \n que no hace nextInt
        System.out.print("Ingrese la descripción: ");
        String descripcion = read.nextLine();
        pokemonController.saveNewPokemon(nombre,nivel,descripcion);
        System.out.println("");
    }

    private void userList() {
        System.out.println("------------------Lista de Usuarios----------------");
        userController.printAllUser();
    }

    private void listPokemonsUser() {
        System.out.println("-----------------Pokemons por usuario----------------");
        userController.printAllUser();
        System.out.print("Ingrese el numero de usuario: ");
        userController.printPokemonsUser(inputOption());
        System.out.println("---------------------------------------------------");
    }

    private void opcionFueraDeRango() {
        System.out.println("opcionFueraDeRango");
    }

    private void salir() {
        System.out.println("Hasta pronto...");
    }

    private void listPokemons() {
        System.out.println("-----------Lista de todos los pokemons--------------");
        pokemonController.printAllPokemon();
    }

    private void evolutionPokemon() {

        System.out.println("-------------Evoluciones de un pokemon---------------");
        System.out.print("Ingrese el Nombre del pokemon: ");
        String nombre = read.nextLine();
        pokemonController.printEvolutionByName(nombre);
    }

    private void buscarPokemon() {
        System.out.println("-------------Buscar un pokemon por su nombre---------------");
        System.out.print("Ingrese el Nombre del pokemon: ");
        String nombre = read.nextLine();
        pokemonController.findByName(nombre);
    }
}
