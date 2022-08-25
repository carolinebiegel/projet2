package com.example.projetgroupe.controller;

import com.example.projetgroupe.bo.Avis;
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

@Controller
public class AvisController {

    @Autowired
    private AvisService avisService;

    @Autowired
    private MembresService membresService;

    @Autowired
    private ArticleService articleService;


    @GetMapping("/avisMembre")
    private String getAvisVendeur (String pseudo, Model model) {
        Membres membre = membresService.getMembresById(pseudo);

        membre.setListeAvis(avisService.findAvisByMembre(pseudo));
        membre.setListeArticles(articleService.findArticleByMembre(pseudo));

        model.addAttribute("membre", membre);

        return "affichageDetailVendeur";
    }


    @GetMapping("/admin/avis")
    public String getAvis(String pseudo, Model model) {
        Membres membre = membresService.getMembresById(pseudo);
        model.addAttribute("membre", membre);
        model.addAttribute("avis", new Avis());

        majModeleAvecListes(model);
        return "avisMembre";
    }




    @PostMapping("/admin/avis")
    private String postAddAvis(String pseudo, @AuthenticationPrincipal Utilisateur utilisateurConnecte, @Valid Avis avis, BindingResult br, Model model) {

        Membres membre = membresService.getMembresById(pseudo);
        avis.setMembres(membre);

        Membres auteur = utilisateurConnecte.getMembre();
        avis.setAuteur(auteur);


        if (br.hasErrors()) {
            model.addAttribute("listeAvis",avisService.listeAvis());
            model.addAttribute("listeArticles",articleService.listeArticles());
            return "avisMembre";
        }

        try {

            avisService.addAvis(avis);
        } catch (Exception e) {
            model.addAttribute("erreur", e.getMessage());
            model.addAttribute("listeAvis",avisService.listeAvis());
            model.addAttribute("listeArticles",articleService.listeArticles());
            return "avisMembre";
        }



        return "redirect:/avisMembre?pseudo=" + avis.getMembres().getPseudo();

    }


    private void majModeleAvecListes(Model model) {
        model.addAttribute("listeAvis", avisService.listeAvis());
        model.addAttribute("listeArticles", articleService.listeArticles());
    }





    private void addMembreAuModel(Model model, String membreId) {
        model.addAttribute("membre", membresService.getMembresById(membreId));
    }

    }




