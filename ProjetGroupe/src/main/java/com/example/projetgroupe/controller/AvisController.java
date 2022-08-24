package com.example.projetgroupe.controller;

import com.example.projetgroupe.bo.Avis;
import com.example.projetgroupe.bo.Membres;
import com.example.projetgroupe.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AvisController {

    @Autowired
    private AvisService avisService;

    @GetMapping("/admin/avis")
    public String getAvis(Model model) {
        model.addAttribute("avis", new Avis());
        return "avisMembre";
    }

    @PostMapping
    public String postAvis(Model model, Avis avis) {
        avisService.addAvis(avis);
        model.addAttribute("listeAvis", avisService.listeAvis());
        return "redirect:/admin/avisMembre";
    }
    @PostMapping("/admin/profil")
    private String postAddAvis(@Valid Avis avis, BindingResult br, Model model) {

        // si on a des erreurs de validations, on retourne  le template pour les afficher
        if (br.hasErrors()) {
            model.addAttribute("listeAvis", avisService.listeAvis());
            return "creationAvis";
        }

        // creer le membre via membreService
        try {
            avisService.addAvis(avis);
        }
        // si jamais ca se passe mal
        catch (Exception e) {
            // on ajoute un attribut "erreur" au modèle
            model.addAttribute("erreur", e.getMessage());
            model.addAttribute("listeMembres", avisService.listeAvis());
            return "Profil";
        }
        return "redirect:/";
    }

}
