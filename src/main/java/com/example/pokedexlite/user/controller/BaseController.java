package com.example.pokedexlite.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BaseController {

    @GetMapping({"/", ""})
    public String redirect() {
        return "redirect:user/";
    }
}