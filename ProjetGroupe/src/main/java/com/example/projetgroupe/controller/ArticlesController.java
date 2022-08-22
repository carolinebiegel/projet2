package com.example.projetgroupe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticlesController {

    @GetMapping("/")
    private String getArticles (Model model) {
        return "affichageListeArticles";
    }


}
