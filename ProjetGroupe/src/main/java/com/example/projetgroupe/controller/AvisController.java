package com.example.projetgroupe.controller;

import com.example.projetgroupe.bo.Avis;
import com.example.projetgroupe.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
