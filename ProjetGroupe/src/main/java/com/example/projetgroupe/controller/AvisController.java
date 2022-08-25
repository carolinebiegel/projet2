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


import javax.validation.Valid;

@Controller
public class AvisController {

    @Autowired
    private AvisService avisService;

    @Autowired
    private MembresService membresService;


    @GetMapping("/avisMembre")
    private String getAvisVendeur (Model model) {
        model.addAttribute("listeAvis",avisService.listeAvis());
        return "affichageDetailVendeur";
    }


    @GetMapping("/admin/avis")
    public String getAvis(String membreId, Model model) {
        model.addAttribute("avis", new Avis());
        this.addMembreAuModel(model, membreId);
        return "avisMembre";
    }



        Membres membres = new Membres();

    @PostMapping("/admin/avis")
    private String postAddAvis(@AuthenticationPrincipal Utilisateur utilisateurConnecte, @Valid Avis avis, BindingResult br, Model model) {


        if (br.hasErrors()) {
            majModeleAvecListes(model);
            return "avisMembre";
        }
        try {

            avis.setMembres(utilisateurConnecte.getMembre());
            avisService.addAvis(avis);
        } catch (Exception e) {
            model.addAttribute("erreur", e.getMessage());
            majModeleAvecListes(model);
            return "avisMembre";
        }



        return "redirect:/avisMembre?id=" + avis.getMembres();

    }


    private void majModeleAvecListes(Model model) {
        model.addAttribute("listeAvis", avisService.listeAvis());
    }



}

    private void addMembreAuModel(Model model, String membreId) {
        model.addAttribute("membre", membresService.getMembresById(membreId));
    }

    }




