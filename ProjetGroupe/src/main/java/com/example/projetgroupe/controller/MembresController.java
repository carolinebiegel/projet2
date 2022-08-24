package com.example.projetgroupe.controller;
import com.example.projetgroupe.bo.Membres;
import com.example.projetgroupe.service.MembresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
@Controller
public class MembresController {
    @Autowired
    private MembresService membresService;
    @GetMapping("/admin/profil")
    private String getProfil(Model model) {
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




