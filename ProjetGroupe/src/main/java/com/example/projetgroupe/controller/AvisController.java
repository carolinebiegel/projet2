package com.example.projetgroupe.controller;

import com.example.projetgroupe.bo.Avis;
import com.example.projetgroupe.bo.Membres;
import com.example.projetgroupe.security.Utilisateur;
import com.example.projetgroupe.service.AvisService;
import com.example.projetgroupe.service.MembresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/avis")
public class AvisController {

    @Autowired
    private AvisService avisService;

    @Autowired
    private MembresService membresService;

    @GetMapping
    public String getAvis(String membreId, Model model) {
        model.addAttribute("avis", new Avis());
        this.addMembreAuModel(model, membreId);
        return "avisMembre";
    }

    private void addMembreAuModel(Model model, String membreId) {
        model.addAttribute("membre", membresService.getMembresById(membreId));
    }

    @PostMapping
    private String postAddAvis(@AuthenticationPrincipal Utilisateur utilisateurConnecte, @Valid Avis avis, BindingResult br, Model model) {

        Membres membres;

        if (br.hasErrors()) {
            majModeleAvecListes(model);
            return "avisMembre";
        }
        try{

            avis.setMembres(utilisateurConnecte.getMembre());
            avisService.addAvis(avis);
        } catch (Exception e) {
            model.addAttribute("erreur", e.getMessage());
            majModeleAvecListes(model);
            return "avisMembre";
        }


        return "redirect:/admin/profil" ;
    }

    private void majModeleAvecListes(Model model) {
        model.addAttribute("listeMembres", membresService.listeMembres());
    }


    }



