package com.example.projetgroupe.controller;

import com.example.projetgroupe.bo.Articles;
import com.example.projetgroupe.bo.Membres;
import com.example.projetgroupe.security.Utilisateur;
import com.example.projetgroupe.service.ArticleService;
import com.example.projetgroupe.service.AvisService;
import com.example.projetgroupe.service.MembresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MembresController {
    @Autowired
    private MembresService membresService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AvisService avisService;



    @GetMapping("/admin/profil")
    private String getProfil(@AuthenticationPrincipal Utilisateur utilisateurConnecte, Model model) {
        Membres membre = utilisateurConnecte.getMembre();
        model.addAttribute("membre", utilisateurConnecte.getMembre());

        membre.setListeAvis(avisService.findAvisByMembre(membre.getPseudo()));
        membre.setListeArticles(articleService.findArticleByMembre(membre.getPseudo()));
        return "membres";
    }


    @GetMapping("/creationProfil")
    public String getCreaProfil(Model model) {
        model.addAttribute("membres", new Membres());
        return "creationProfil";
    }



    @PostMapping("/admin/profil")
    private String postMembre(@Valid Membres membres, BindingResult br, Model model) {
        // si on a des erreurs de validations, on retourne  le template pour les afficher
        if (br.hasErrors()) {
            model.addAttribute("listeMembres", membresService.listeMembres());
            return "membres";
        }
        // creer le membre via membreService
        try {

            membresService.addMembres(membres);
        }
        // si jamais ca se passe mal
        catch (Exception e) {
            // on ajoute un attribut "erreur" au modèle
            model.addAttribute("erreur", e.getMessage());
            model.addAttribute("listeMembres", membresService.listeMembres());
            return "membres";
        }
        return "redirect:/admin/membres";
    }
    @PostMapping("/creationProfil")
    private String postAddProfil(@Valid Membres membres, BindingResult br, Model model) {
        // si on a des erreurs de validations, on retourne  le template pour les afficher
        if (br.hasErrors()) {
            model.addAttribute("listeMembres", membresService.listeMembres());
            return "creationProfil";
        }
        // creer le membre via membreService
        try {
            membresService.addMembres(membres);
        }
        // si jamais ca se passe mal
        catch (Exception e) {
            // on ajoute un attribut "erreur" au modèle
            model.addAttribute("erreur", e.getMessage());
            model.addAttribute("listeMembres", membresService.listeMembres());
            return "creationProfil";
        }
        return "redirect:/";
    }
}




