package com.example.pokedexlite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("My application from command line");
        Scanner read = new Scanner(System.in);
        int num = read.nextInt();
        System.out.println("My application is finished: " + num);

    }
}
