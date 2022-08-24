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

}





