package com.example.projetgroupe.controller;

import com.example.projetgroupe.bo.Articles;
import com.example.projetgroupe.bo.Genres;
import com.example.projetgroupe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ArticlesController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    private String getArticles (Model model) {
        model.addAttribute("listeArticles",articleService.listeArticles());
        return "affichageListeArticles";
    }

    @GetMapping("/admin/vendre")
    private String getArticleVendre(Model model) {
        model.addAttribute("article", new Articles());
        model.addAttribute("listeGenres", Genres.values());

        majModeleAvecListes(model);
        return "venteArticle";
    }

    @PostMapping("/admin/vendre")
    private String postArticle(@Valid Articles article, BindingResult br, Model model) {

        // si on a des erreurs de validations, on retourne  le template pour les afficher
        if (br.hasErrors()) {
            majModeleAvecListes(model);
            return "venteArticle";
        }

        // creer le participant via participantService
        try {
            articleService.addArticle(article);
        }
        // si jamais ca se passe mal
        catch (Exception e) {
            model.addAttribute("article", new Articles());
            majModeleAvecListes(model);
            return "venteArticle";
        }
        return "redirect:/";
    }

    /**
     * Pour ne pas se répeter, je refactorise mes ajouts de listes au modèle dans une méthode à part
     */
    private void majModeleAvecListes(Model model) {
        model.addAttribute("listeArticles", articleService.listeArticles());
    }


}
