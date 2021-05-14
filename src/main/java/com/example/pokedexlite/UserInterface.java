package com.example.pokedexlite;

import com.example.pokedexlite.pokemon.controller.PokemonController;
import com.example.pokedexlite.user.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInterface {

    static final int SALIR = 0, LISTAR_OPCIONES = 1, LISTAR_USUARIOS = 2, LISTAR_POKEMONS = 3, LISTAR_POKEMONS_POR_USUARIO = 4, AGREGAR_POKEMON = 5;

    @Autowired
    PokemonController pokemonController;
    @Autowired
    UserController userController;


    int listOptions() {
        System.out.println("------------------Lista de Opciones----------------");
        System.out.println(LISTAR_OPCIONES + " .-Listar todas las opciones");
        System.out.println(LISTAR_USUARIOS + " .-Listar todos los usuarios");
        System.out.println(LISTAR_POKEMONS + " .-Listar todas los pokemons");
        System.out.println(LISTAR_POKEMONS_POR_USUARIO + " .-Listar los pokemons por usuario");
        System.out.println(AGREGAR_POKEMON + " .-Editar pokemon");
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

            case SALIR:
                salir();
                break;
            default:
                opcionFueraDeRango();
        }
        return numero;
    }

    private void newPokemon() {
        Scanner read = new Scanner(System.in);
        System.out.println("newPokemon()");
        System.out.print("Ingrese el Nombre: ");
        String nombre = read.nextLine();
        System.out.print("Ingrese el Nivel: ");
        int nivel = read.nextInt();
        read.nextLine(); // para consumir el \n que no hace nextInt
        System.out.print("Ingrese la descripción: ");
        String descripcion = read.nextLine();
        System.out.println("Los datos son:" + nombre + " " + nivel + " " + descripcion);
        pokemonController.saveNewPokemon(nombre,nivel,descripcion);
    }

    private void userList() {
        System.out.println("userList()");
        userController.printAllUser();
    }

    private void listPokemonsUser() {
        System.out.println("\n\nlistPokemonsPorUsuario()");
        userController.printAllUser();
        System.out.print("Ingrese el numero de usuario: ");
        userController.printPokemonsUser(inputOption());
    }

    private void opcionFueraDeRango() {
        System.out.println("opcionFueraDeRango");
    }

    private void salir() {
        System.out.println("salir()");
    }

    private void listPokemons() {
        System.out.println("listPokemons()");
        pokemonController.printAllPokemon();
    }
}
