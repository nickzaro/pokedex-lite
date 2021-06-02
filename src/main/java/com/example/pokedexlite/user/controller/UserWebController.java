package com.example.pokedexlite.user.controller;

import com.example.pokedexlite.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping({"/user"})
public class UserWebController {
    @Autowired
    IUserService userService;


    @GetMapping("/")
    public String printAllUsers(Model model){
        model.addAttribute("title","All users");
        model.addAttribute("users",userService.findAll());
        return "user/printAllUsers";
    }
}
