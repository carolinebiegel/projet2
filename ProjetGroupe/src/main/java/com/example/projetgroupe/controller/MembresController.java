package com.example.projetgroupe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembresController {


    @GetMapping("/profil")

    private String getProfil (Model model) {


        return "membres";
    }




}
